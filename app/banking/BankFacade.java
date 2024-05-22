package app.banking;

import app.framework.domain.AccountType;
import app.framework.exceptions.AccountCreationException;
import app.framework.exceptions.AccountNotFoundException;

import java.time.LocalDate;

public interface BankFacade {
    void createPersonalAccount(String accNr, String name, String street, String city, String state, String zip , LocalDate birthDate, String email, AccountType accountType) throws AccountCreationException;
    void createCompanyAccount(String accNr,String name,String street,String city,String state,String zip, int numberOfEmployee,String email,AccountType accountType) throws AccountCreationException;
    void withDraw(String accNumber,double amount) throws AccountNotFoundException;
    void deposit(String accNumber,double amount) throws AccountNotFoundException;
    void  addInterest(String accNumber);
}