package app.creditcard;

import app.framework.Account;
import app.framework.Customer;
import app.framework.Entry;

import java.time.LocalDateTime;

public class CreditAccount extends Account {
    public CreditAccount(String accNumber, Customer customer) {
        super(accNumber, customer);
    }

    @Override
    public Entry getEntry(double amount,String description) {
        return new CreditCardEntry(amount, description, LocalDateTime.now());
    }
}
