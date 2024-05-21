package app.framework.storage;

import app.framework.Account;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class AccountStorage implements Database<Account>{
    private static AccountStorage instance = new AccountStorage();
    Storage store;

    public static final String OUTPUT_DIR = String.join(
            File.separator,
            new String[]{System.getProperty("user.dir"),"app","framework","storage",".accounts"}
    );

    Path path = FileSystems.getDefault().getPath(OUTPUT_DIR);

    public static AccountStorage getInstance(){
        return AccountStorage.instance;
    }

    private AccountStorage(){
        this.store = new Storage(path);
    }

     HashMap<String, Account> getAccounts(){
        return (HashMap<String, Account>) this.store.read();
    }

    @Override
    public void save(Account account) {
        HashMap<String, Account> accounts = (HashMap<String, Account>) this.store.read();
        accounts.put(account.getAccNumber(),account);
        this.store.save(accounts);
    }

    @Override
    public void update(Account account) {
        this.save(account);
    }

    @Override
    public Account get(String accountNumber) {
        HashMap<String, Account> accounts = (HashMap<String, Account>) this.store.read();
        return accounts.get(accountNumber);
    }

    @Override
    public Collection<Account> getAll() {
        HashMap<String, Account> accountsMap = (HashMap<String, Account>) this.store.read();
        ArrayList<Account> accounts = new ArrayList<>();
        for(String id: accountsMap.keySet()){
            accounts.add(accountsMap.get(id));
        }
        return accounts;
    }
}
