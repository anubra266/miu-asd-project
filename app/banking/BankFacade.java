package app.banking;

import app.banking.customer.Individual;
import app.banking.customer.Organization;
import app.framework.domain.AccountType;
import app.framework.domain.Address;
import app.framework.domain.Customer;
import app.framework.domain.Subject;
import app.framework.exceptions.AccountCreationException;
import app.framework.exceptions.AccountNotFoundException;

import java.time.LocalDate;

abstract class BankFacade extends Subject {

    public void createAccount(String accNr, String name, String street, String city, String state, String zip,
            String email, AccountType accountType, LocalDate birthDate) throws AccountCreationException {
        Address address = new Address(street, state, city, zip);
        Customer customer = new Individual(name, email, address, birthDate);
        createAccount(customer, accNr, accountType);

    }

    public void createAccount(String accNr, String name, String street, String city, String state, String zip,
            String email, AccountType accountType, int numberOfEmployee) throws AccountCreationException {
        Address address = new Address(street, state, city, zip);
        Customer customer = new Organization(name, email, address, numberOfEmployee);
        createAccount(customer, accNr, accountType);
    }

    abstract void createAccount(Customer customer, String accNr, AccountType accountType)
            throws AccountCreationException;

    abstract void withDraw(String accNumber, double amount) throws AccountNotFoundException;

    abstract void deposit(String accNumber, double amount) throws AccountNotFoundException;

    abstract void addInterest();
}