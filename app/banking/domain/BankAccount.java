package app.banking.domain;

import app.framework.domain.Account;
import app.framework.domain.Customer;
import app.framework.domain.Entry;
import app.framework.domain.Event;

import java.time.LocalDateTime;

public class BankAccount extends Account {
    public BankAccount(String accNumber, Customer customer) {
        super(accNumber, customer);
    }

    @Override
    public Entry getEntry(double amount, String description, Event event) {
        return new BankEntry(amount, description, LocalDateTime.now(),event, "", "");
    }
}
