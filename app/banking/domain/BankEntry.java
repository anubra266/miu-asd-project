package app.banking.domain;

import app.framework.domain.Entry;
import app.framework.domain.Event;

import java.time.LocalDateTime;

public class BankEntry extends Entry {
    private final String partyAccountNumber;
    private final String partyName;

    public BankEntry(double amount, String description, LocalDateTime date, Event event, String partyAccountNumber, String partyName) {
        super(amount, date, description,event);
        this.partyAccountNumber = partyAccountNumber;
        this.partyName = partyName;
    }

    public String getPartyAccountNumber() {
        return this.partyAccountNumber;
    }

    public String getPartyName() {
        return this.partyName;
    }
}
