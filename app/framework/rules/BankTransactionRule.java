package app.framework.rules;

import app.banking.domain.BankAccount;
import app.banking.domain.BankEntry;
import app.framework.domain.Event;

public interface BankTransactionRule extends Rule<BankAccount, BankEntry> {
    default public boolean matches(BankAccount bankAccount, BankEntry entry) {
        return matches(bankAccount,entry.getAmount(),entry.getDescription(), entry.getEvent());
    }

    default public void apply(BankAccount bankAccount, BankEntry entry) {
        apply(bankAccount,entry.getAmount(),entry.getDescription(), entry.getEvent());
    }

    public boolean matches(BankAccount bankAccount, Double amount, String description, Event event);


    public void apply(BankAccount bankAccount, Double amount, String description, Event event);
}
