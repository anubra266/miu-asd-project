package app.framework;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private final String accNumber;
    private final Customer customer;
    private PercentageStrategy percentageStrategy;
    private final List<Entry> entryList = new ArrayList<Entry>();

    public Account(String accNumber, Customer customer) {
        this.accNumber = accNumber;
        this.customer = customer;
    }

    public void setPercentageStrategy(PercentageStrategy strategy){
        this. percentageStrategy = strategy;
    }

    public String getAccNumber() {
        return this.accNumber;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public double getBalance() {
        double balance = 0;
        for (Entry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void addInterest() {
        double interest = this.percentageStrategy.getPercentAmount(getBalance());
        Entry entry = this.getInterestEntry(interest);
        entryList.add(entry);
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract Entry getInterestEntry(double amount);
}
