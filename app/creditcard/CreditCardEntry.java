package app.creditcard;

import app.framework.domain.Entry;

import java.time.LocalDateTime;

public class CreditCardEntry extends Entry {
    public CreditCardEntry(double amount, String description, LocalDateTime date) {
        super(amount, date, description);
    }
}
