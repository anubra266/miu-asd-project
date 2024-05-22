package app.creditcard;

import app.framework.exceptions.AccountCreationException;

import java.time.LocalDate;

public interface CreditCardFacade {
    void createAccount(String name, String street, String city, String state, String zip, String Email, String ccNumber,
            LocalDate exprDate, CreditCardType type)  throws AccountCreationException;

    void generateMonthlyBill();

    void chargeAmount(double amount, String ccNumber);

    void deposit(double amount, String ccNumber);

}
