package app.creditcard;

import app.creditcard.observers.CreditCardEmailSender;
import app.creditcard.strategies.*;
import app.framework.domain.*;
import app.framework.exceptions.AccountCreationException;
import app.creditcard.strategies.BronzeMonthlyInterestPercentageStrategy;
import app.creditcard.strategies.GoldMonthlyInterestPercentageStrategy;
import app.creditcard.strategies.SilverMinimumPaymentPercentageStrategy;
import app.framework.exceptions.CreditInvalidDepositException;
import app.framework.facade.CommonBankFacadeImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class CreditCardFacadeImpl extends CommonBankFacadeImpl<CreditAccount, CreditCardEntry,String> implements CreditCardFacade {

    private static CreditCardFacadeImpl instance = new CreditCardFacadeImpl();
    PercentageStrategy percentageStrategy;
    PercentageStrategy minimumPaymentStrategy;

    private CreditCardFacadeImpl() {
        super(CreditAccountDAO.getInstance(),null, new ArrayList<Observer>(){
            {
                add(CreditCardEmailSender.getInstance());
            }
        });
    };

    public static CreditCardFacadeImpl getInstance() {
        return CreditCardFacadeImpl.instance;
    }

    @Override
    public void createAccount(String name, String street, String city, String state, String zip, String email,
            String ccNumber, LocalDate exprDate, CreditCardType type) throws AccountCreationException {

        if (this.getDatabase().isUnique(ccNumber)) {
            Address address = new Address(street, city, state, zip);
            Customer customer = new Customer(name, email, address);
            CreditAccount account = new CreditAccount(ccNumber, customer, exprDate);

            switch (type) {
                case GOLD:
                    percentageStrategy = new GoldMonthlyInterestPercentageStrategy();
                    minimumPaymentStrategy = new GoldMinimumPaymentPercentageStrategy();
                    break;
                case SILVER:
                    percentageStrategy = new SilverMonthlyInterestPercentageStrategy();
                    minimumPaymentStrategy = new SilverMinimumPaymentPercentageStrategy();
                    break;
                case BRONZE:
                    percentageStrategy = new BronzeMonthlyInterestPercentageStrategy();
                    minimumPaymentStrategy = new BronzeMinimumInterestPercentageStrategy();
                    break;
                default:
                    throw new AccountCreationException("Invalid Credit card type " + type);

            }
            account.setPercentageStrategy(percentageStrategy);
            account.setMinimumPaymentStrategy(minimumPaymentStrategy);

            this.getDatabase().save(ccNumber, account);
        }else{
            throw new AccountCreationException("Credit Card  with number " + ccNumber + " already exists");
        }


    }

    @Override
    public Collection<String> generateMonthlyBill() {
        Collection<CreditAccount> accounts = this.getDatabase().getAll();
        return accounts.stream().map(acc -> {
            double previousBalance = acc.getBalance() - acc.calculateCurrentMonthEntriesBalance();
            double totalCharges = acc.calculateCurrentMonthEntriesTotalDebits();
            double totalCredits = acc.calculateCurrentMonthEntriesTotalCredits();
            double owedAmount = previousBalance + totalCredits;
            double owedInterest = acc.getPercentageStrategy().getPercentAmount(owedAmount);
            double newBalance = owedAmount + owedInterest + totalCharges;
            double minimumPayment = acc.getMinimumPaymentStrategy().getPercentAmount(newBalance);

            return String.format(
                    "Name= %s\nAddress= %s\nCC number= %s\nCC type= %s\nPrevious balance = $ %.2f\nTotal Credits = $ %.2f\nTotal Charges = $ %.2f\nNew balance = $ %.2f\nTotal amount due = $ %.2f\n",acc.getCustomer().getName(), acc.getCustomer().getAddress().getAddress(), acc.getAccNumber(),
                    acc.getPercentageStrategy().getName(), previousBalance, totalCredits, totalCharges, newBalance,
                    minimumPayment);
        }).collect(Collectors.toList());
    }

    @Override
    public void chargeAmount(String ccNumber, double amount) {
        CreditAccount account = this.getDatabase().get(ccNumber);
        if(amount > 400){
            this.alert(Event.CHARGE, account);
        }
        account.withdraw(amount, "charge");
        this.getDatabase().save(ccNumber, account);
    }

    @Override
    public void deposit(String ccNumber, double amount) throws CreditInvalidDepositException {
        CreditAccount account = this.getDatabase().get(ccNumber);
        if (account.getBalance() >= 0 || account.getBalance() + amount > 0) {
            throw new CreditInvalidDepositException("Cannot deposit more than you owe");
        }
        account.deposit(amount, "deposit");
        this.getDatabase().save(ccNumber, account);
    }

    public Collection<CreditAccount> getAccounts() {
        return this.getDatabase().getAll();
    }

}
