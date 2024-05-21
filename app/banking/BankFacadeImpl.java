package app.banking;

import java.time.LocalDate;

public class BankFacadeImpl implements BankFacade{
    @Override
    public void createPersonalAccount(String accNr, String name, String street, String city, String state, String zip, LocalDate birthDate, String email) {

    }

    @Override
    public void createCompanyAccount(String accNr, String name, String street, String city, String state, String zip, int numberOfEmployee, String email) {

    }

    @Override
    public void withDraw(double amount) {

    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void addInterest() {

    }
}
