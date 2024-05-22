package app.banking;

import app.framework.Account;
import app.framework.Customer;
import app.framework.Entry;

import java.time.LocalDate;
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
