package app.framework.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Entry  implements Serializable {

    private static final long serialVersionUID = -89120923487374888L;


    private LocalDateTime date;
    private double amount;
    private String description;

    public Entry(double amount, LocalDateTime date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

}
