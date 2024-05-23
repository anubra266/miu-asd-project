package app.banking.domain;

import app.framework.domain.Entry;
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
}
