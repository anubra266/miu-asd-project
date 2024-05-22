package app.framework;

import app.ui.bank.AccountEntry;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accNumber;
    private Customer customer;
    private PercentageStrategy percentageStrategy;
    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

    public Account(String accNumber, PercentageStrategy type) {
        this.accNumber = accNumber;
        this.percentageStrategy = type;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    private void addEntry(AccountEntry entry) {
        entryList.add(entry);
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
        entryList.add(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
        entryList.add(entry);
    }


    //Strategy Pattern

    public void addInterest() {
        double interest = this.percentageStrategy.getPercentAmount(getBalance());
        AccountEntry entry = new AccountEntry(interest, "added interest", "", "");
        entryList.add(entry);
    }


}
