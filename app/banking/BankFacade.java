package app.banking;

import app.banking.customer.Personal;
import app.banking.customer.Company;
import app.banking.domain.BankAccount;
import app.banking.domain.BankEntry;
import app.framework.domain.*;
import app.framework.exceptions.AccountCreationException;
import app.framework.exceptions.AccountNotFoundException;
import app.framework.facade.CommonBankFacadeImpl;
import app.framework.persistence.DAO;
import app.framework.persistence.Database;
import app.framework.rules.RuleEngine;

import java.time.LocalDate;
import java.util.List;

abstract class BankFacade extends CommonBankFacadeImpl<BankAccount, BankEntry,String> {

    public BankFacade(DAO<BankAccount,String> database, RuleEngine<BankAccount,BankEntry> ruleEngine, List<Observer> list) {
        super(database, ruleEngine, list);
    }

    public void createAccount(String accNr, String name, String street, String city, String state, String zip,
                              String email, AccountType accountType, LocalDate birthDate) throws AccountCreationException {
        Address address = new Address(street, state, city, zip);
        Customer customer = new Personal(name, email, address, birthDate);
        createAccount(customer, accNr, accountType);

    }

    public void createAccount(String accNr, String name, String street, String city, String state, String zip,
                              String email, AccountType accountType, int numberOfEmployee) throws AccountCreationException {
        Address address = new Address(street, state, city, zip);
        Customer customer = new Company(name, email, address, numberOfEmployee);
        createAccount(customer, accNr, accountType);
    }

    abstract void createAccount(Customer customer, String accNr, AccountType accountType)
            throws AccountCreationException;

    abstract void withDraw(String accNumber, double amount) throws AccountNotFoundException;

    abstract void deposit(String accNumber, double amount) throws AccountNotFoundException;

}