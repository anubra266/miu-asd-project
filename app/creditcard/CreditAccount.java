package app.creditcard;

import app.framework.Account;
import app.framework.Customer;
import app.framework.Entry;

import java.time.LocalDate;

public class CreditAccount extends Account {
    public CreditAccount(String accNumber, Customer customer) {
        super(accNumber, customer);
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public Entry getInterestEntry(double amount) {
        return new CreditCardEntry(amount, "interest", LocalDate.now());
    }
}
