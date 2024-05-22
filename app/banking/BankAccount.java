package app.banking;

import app.creditcard.CreditCardEntry;
import app.framework.Account;
import app.framework.Customer;
import app.framework.Entry;

import java.time.LocalDate;

public class BankAccount extends Account {
    public BankAccount(String accNumber, Customer customer) {
        super(accNumber, customer);
    }

    @Override
    public void deposit(double amount,String description) {
        CreditCardEntry entry = new CreditCardEntry(amount,description, LocalDate.now());
        this.addEntry(entry);
    }

    @Override
    public void withdraw(double amount, String description) {
        CreditCardEntry entry = new CreditCardEntry(-amount,description, LocalDate.now());
        this.addEntry(entry);
    }


    @Override
    public Entry getInterestEntry(double amount) {
        return new BankEntry(amount,"interest", LocalDate.now(),"","");
    }
}
