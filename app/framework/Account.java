package app.framework;

import javax.naming.OperationNotSupportedException;
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

    public void addEntry(Entry entry){
        this.entryList.add(entry);
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
        this.addEntry(entry);
    }

    public void deposit(double amount, String description) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    };

    public abstract void withdraw(double amount, String description);

    public abstract Entry getInterestEntry(double amount);
}
