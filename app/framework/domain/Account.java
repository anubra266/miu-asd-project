package app.framework.domain;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.stream.Collectors;

public abstract class Account {
    private final String accNumber;
    private final Customer customer;
    private PercentageStrategy percentageStrategy;
    private final List<Entry> entryList = new ArrayList<Entry>();

    public Account(String accNumber, Customer customer) {
        this.accNumber = accNumber;
        this.customer = customer;
    }

    public void addEntry(Entry entry) {
        this.entryList.add(entry);
    }

    public void setPercentageStrategy(PercentageStrategy strategy) {
        this.percentageStrategy = strategy;
    }

    public String getAccNumber() {
        return this.accNumber;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    private List<Entry> getCurrentMonthEntries() {
        LocalDateTime now = LocalDateTime.now();
        YearMonth currentMonth = YearMonth.from(now);

        return entryList.stream()
                .filter(entry -> YearMonth.from(entry.getDate()).equals(currentMonth))
                .collect(Collectors.toList());
    }

    public double calculateCurrentMonthEntriesBalance() {
        return getCurrentMonthEntries().stream()
                .mapToDouble(Entry::getAmount)
                .sum();
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
        Entry entry = this.getEntry(interest, "interest");
        this.addEntry(entry);
    }


    public void deposit(double amount, String description){
        Entry entry = this.getEntry(amount, description);
        this.addEntry(entry);
    };


    public void withdraw(double amount, String description){
        Entry entry = this.getEntry(-amount, description);
        this.addEntry(entry);
    };

    public abstract Entry getEntry(double amount, String description);

    public List<Entry> getEntryList() {
        return this.entryList;
    }
}