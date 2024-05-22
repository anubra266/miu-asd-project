package app.framework;

import java.time.LocalDateTime;

public class Entry {
    private LocalDateTime date;
    private double amount;

    private String description;

    public Entry(double amount, LocalDateTime date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

}
