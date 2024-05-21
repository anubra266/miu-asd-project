package app.creditcard;

import java.time.LocalDate;

public interface CreditCardFacade {
    void createAccount(String name, String street, String city, String state, String zip, String Email, String ccNumber, LocalDate exprDate);
    void generateMonthlyBill();
    void chargeAmount();
    void deposit(double amount);
}
