package app.framework;

import java.time.LocalDate;

public class Entry {
    private LocalDate date;
    private double amount;

    public Entry(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

}
