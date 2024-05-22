package app.creditcard;

import app.framework.domain.Account;
import app.framework.domain.Customer;
import app.framework.domain.Entry;
import app.framework.domain.PercentageStrategy;

import java.time.LocalDateTime;

public class CreditAccount extends Account {

    private PercentageStrategy minimumPaymentStrategy;

    public CreditAccount(String accNumber, Customer customer) {
        super(accNumber, customer);
    }

    public void setMinimumPaymentStrategy(PercentageStrategy strategy) {
        this.minimumPaymentStrategy = strategy;
    }

    public PercentageStrategy getMinimumPaymentStrategy() {
        return this.minimumPaymentStrategy;
    }

    @Override
    public Entry getEntry(double amount, String description) {
        return new CreditCardEntry(amount, description, LocalDateTime.now());
    }
}
