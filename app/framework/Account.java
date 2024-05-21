package app.framework;

import app.ui.bank.AccountEntry;

import java.util.ArrayList;
import java.util.List;

public  class  Account {
    public String AccountNumber;
    public double balance;

    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();


    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void addEntry(AccountEntry entry) {
        entryList.add(entry);
    }
    
    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
        entryList.add(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
        entryList.add(entry);
    }
}
