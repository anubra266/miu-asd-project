package app.creditcard;

import app.framework.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreditAccount extends Account {

    private LocalDate exprDate;
    private PercentageStrategy minimumPaymentStrategy;

    public CreditAccount(String accNumber, Customer customer, LocalDate expirationDate) {
        super(accNumber, customer);
        this.exprDate = expirationDate;
    }

    public void setMinimumPaymentStrategy(PercentageStrategy strategy) {
        this.minimumPaymentStrategy = strategy;
    }

    public PercentageStrategy getMinimumPaymentStrategy() {
        return this.minimumPaymentStrategy;
    }

    @Override
    public Entry getEntry(double amount, String description, Event event) {
        return new CreditCardEntry(amount, description, LocalDateTime.now(),event);
    }

    public LocalDate getExprDate() {
        return this.exprDate;
    }
}
