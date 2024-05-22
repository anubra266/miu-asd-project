package app.creditcard;

import app.framework.Entry;

import java.time.LocalDate;

public class CreditCardEntry extends Entry {
    private String name;

    public CreditCardEntry(double amount, String name, LocalDate date) {
        super(amount, date);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
