package app.creditcard;

import app.framework.domain.Entry;
import app.framework.domain.Event;

import java.time.LocalDateTime;

public class CreditCardEntry extends Entry {
    public CreditCardEntry(double amount, String description, LocalDateTime date, Event event) {
        super(amount, date, description,event);
    }
}
