package app.creditcard;

import app.framework.exceptions.AccountCreationException;

import java.time.LocalDate;

import app.framework.exceptions.CreditInvalidDepositException;
import java.util.Collection;

public interface CreditCardFacade {
    void createAccount(String name, String street, String city, String state, String zip, String Email, String ccNumber,
            LocalDate exprDate, CreditCardType type) throws AccountCreationException;

    Collection<String> generateMonthlyBill();

    void chargeAmount( String ccNumber, double amount);

    void deposit(String ccNumber, double amount) throws CreditInvalidDepositException;
}
