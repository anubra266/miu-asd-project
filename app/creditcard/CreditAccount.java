package app.creditcard;

import app.framework.domain.Account;
import app.framework.domain.Customer;
import app.framework.domain.Entry;

import java.time.LocalDateTime;

public class CreditAccount extends Account {
    public CreditAccount(String accNumber, Customer customer) {
        super(accNumber, customer);
    }

    @Override
    public Entry getEntry(double amount,String description) {
        return new CreditCardEntry(amount, description, LocalDateTime.now());

    @Override
    public Entry getInterestEntry(double amount) {
        return new CreditCardEntry(amount, "interest", LocalDate.now());
    }
}
