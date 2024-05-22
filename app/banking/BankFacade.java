package app.banking;

import java.time.LocalDate;

public interface BankFacade {
    void createPersonalAccount(String accNr, String name, String street, String city, String state, String zip , LocalDate birthDate, String email);
    void createCompanyAccount(String accNr,String name,String street,String city,String state,String zip, int numberOfEmployee,String email);
    void withDraw(double amount);
    void deposit(double amount);
    void  addInterest();
}
