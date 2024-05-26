package app.framework.rules;

import app.banking.domain.BankAccount;
import app.banking.domain.BankEntry;
import app.framework.domain.Event;

public class BankRuleEngine extends RuleEngine<BankAccount, BankEntry> {

    public void process(BankAccount acc, Double amount, String description, Event event){
        System.out.println("==== Applying rules ====");
        this.getRules().stream()
                .filter(r -> ((BankTransactionRule) r).matches(acc, amount,description,event))
                .forEach(r -> ((BankTransactionRule) r).apply(acc, amount,description,event));
        System.out.println("==== Applied rules ====");
    }
    
}

