package app.banking;

import app.framework.domain.Account;
import app.framework.domain.Customer;
import app.framework.domain.Entry;

import java.time.LocalDateTime;

public class BankAccount extends Account {
    public BankAccount(String accNumber, Customer customer) {
        super(accNumber, customer);
    }

    @Override
    public Entry getEntry(double amount,String description) {
        return new BankEntry(amount,description, LocalDateTime.now(),"","");
    }
}
