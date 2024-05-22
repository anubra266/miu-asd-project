package app.banking;

import app.framework.Entry;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BankEntry extends Entry {
    private final String partyAccountNumber;
    private final String partyName;

    public BankEntry(double amount, String description, LocalDateTime date, String partyAccountNumber, String partyName) {
        super(amount, date,description);
        this.partyAccountNumber = partyAccountNumber;
        this.partyName = partyName;
    }

    public String getPartyAccountNumber() {
        return this.partyAccountNumber;
    }

    public String getPartyName() {
        return this.partyName;
    }

    public String getDescription() {
        return this.description;
    }
}
