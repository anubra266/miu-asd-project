package app.framework.rules;

import app.framework.domain.Account;

import java.util.ArrayList;


public class BankRuleEngine extends RuleEngine<Account,Double> {

        public void addRule(Rule<Account,Double> rule) {
            this.getRules().add(rule);
        }

        public void removeRule(Rule<Account,Double> rule) {
            this.getRules().remove(rule);
        }

        public void resetRules(){
            this.setRules(new ArrayList<>());
        }

        public void process(Account acc, Double amount) {
            System.out.println("==== Applying rules ====");
            this.getRules().stream()
                    .filter(r -> r.matches(acc, amount))
                    .forEach(r -> r.apply(acc, amount));
            System.out.println("==== Applied rules ====");
        }

}
