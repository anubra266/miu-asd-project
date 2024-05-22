package app.creditcard;

import app.framework.domain.*;

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
            String ccNumber, LocalDate exprDate) {
        if (!this.creditCardDatabase.isUnique(ccNumber)) {
            throw new IllegalArgumentException("Credit card number already exists");
        }
        Address address = new Address(street, city, state, zip);
        Customer customer = new Customer(name, email, address);
        CreditAccount account = new CreditAccount(ccNumber, customer);
        this.creditCardDatabase.save(ccNumber, account);
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
