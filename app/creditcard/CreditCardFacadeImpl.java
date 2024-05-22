package app.creditcard;

import app.creditcard.strategies.*;
import app.framework.domain.*;
import app.framework.exceptions.AccountCreationException;

import java.time.LocalDate;
import java.util.Collection;;

public class CreditCardFacadeImpl extends Subject implements CreditCardFacade {

    private static CreditCardFacadeImpl instance = new CreditCardFacadeImpl();
    private CreditAccountDAO creditCardDatabase;

    private CreditCardFacadeImpl() {
        this.creditCardDatabase = CreditAccountDAO.getInstance();
    };

    public static CreditCardFacadeImpl getInstance() {
        return CreditCardFacadeImpl.instance;
    }

    @Override
    public void createAccount(String name, String street, String city, String state, String zip, String email,
            String ccNumber, LocalDate exprDate, CreditCardType type) throws AccountCreationException {

        if (creditCardDatabase.isUnique(ccNumber)) {
            Address address = new Address(street, city, state, zip);
            Customer customer = new Customer(name, email, address);
            CreditAccount account = new CreditAccount(ccNumber, customer, exprDate);

            PercentageStrategy percentageStrategy;
            PercentageStrategy minimumPaymentStrategy;
            switch (type){
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
                    throw new AccountCreationException("Invalid Credit card type "+ type);

            }
            account.setPercentageStrategy(percentageStrategy);
            account.setMinimumPaymentStrategy(minimumPaymentStrategy);

            this.creditCardDatabase.save(ccNumber, account);
            return;
        }

        throw new AccountCreationException("Credit Card  with number " + ccNumber + " already exists");


    }


    @Override
    public void generateMonthlyBill() {
        Collection<CreditAccount> accounts = creditCardDatabase.getAll();
        accounts.stream().map(acc -> {
            // Name= John White
            // Address= 1000 Main, Fairfield, IA, 52556
            // CC number= 2341 3421 4444 5689
            // CC type= GOLD
            // Previous balance = $ 100.00
            // Total Credits = $ 25.00
            // Total Charges = $ 560.00
            // New balance = $ 638.75
            // Total amount due = $ 63.88
            double previousBalance = acc.getBalance() - acc.calculateCurrentMonthEntriesBalance();
            return null;

        });

    }

    @Override
    public void chargeAmount(double amount, String ccNumber) {
        CreditAccount account = this.creditCardDatabase.get(ccNumber);
        account.withdraw(amount, "charge");
        this.creditCardDatabase.save(ccNumber, account);
        this.alert(Event.CHARGE, account);
    }

    @Override
    public void deposit(double amount, String ccNumber) {
        CreditAccount account = this.creditCardDatabase.get(ccNumber);
        account.deposit(amount, "deposit");
        this.creditCardDatabase.save(ccNumber, account);
        this.alert(Event.DEPOSIT, account);
    }


    @Override
    public void alert(Event event, Object obj) {
        for (Observer o : this.getObserverList()) {
            o.callback(event, obj);
        }
    }

}
