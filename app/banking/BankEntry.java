package app.banking;

import app.framework.domain.Entry;

import java.time.LocalDate;

public class BankEntry extends Entry {
    private final String description;
    private final String partyAccountNumber;
    private final String partyName;

    public BankEntry(double amount, String description, LocalDate date, String partyAccountNumber, String partyName) {
        super(amount, date);
        this.partyAccountNumber = partyAccountNumber;
        this.partyName = partyName;
        this.description = description;
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
