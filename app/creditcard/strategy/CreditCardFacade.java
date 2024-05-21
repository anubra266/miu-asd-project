package app.creditcard.strategy;

import java.time.LocalDate;

public interface CreditCardFacade {
    void createCreditCardAccount(String name, String street, String city, String state, String zip, String Email, String ccNumber, LocalDate exprDate);
    void generateMonthlyBill();
    void chargeAmount();
    void deposit(double amount);

}
