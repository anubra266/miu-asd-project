package app.ui.bank.serviceImpl;

import app.framework.*;
import app.framework.storage.AccountDAO;

import java.util.Collection;
import java.util.Date;

public class AccountServiceImpl implements AccountService {
    AccountDAO accountDAO;

    public AccountServiceImpl() {
        accountDAO = new AccountDAO();
    }


    @Override
    public void createCompanyAccount(String accountNumber, String name, String email, Address address, int numberOfEmployee, PercentageStrategy type) {
        Account account = new Account(accountNumber,type);
        Customer customer = new CompanyInfo(name,email,address,numberOfEmployee);
        account.setCustomer(customer);
        accountDAO.save(account);
    }

    @Override
    public void createPersonalAccount(String accountNumber, String name, String email, Address address, Date birthDate, PercentageStrategy type) {
        Account account = new Account(accountNumber,type);
        Customer customer = new PersonalInfo(name,email,address,birthDate);
        account.setCustomer(customer);
        accountDAO.save(account);
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.get(accountNumber);
        account.deposit(amount);
        accountDAO.update(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.get(accountNumber);
        account.withdraw(amount);
        accountDAO.update(account);
    }

    @Override
    public void addInterest(String accountNumber) {
        Account account = accountDAO.get(accountNumber);
        account.addInterest();
        accountDAO.update(account);
    }

    @Override
    public void addInterestAllAccounts() {
        for (Account account : getAllAccounts()) {
            account.addInterest();
        }
    }


    public Collection<Account> getAllAccounts() {
        return accountDAO.getAll();
    }

}
