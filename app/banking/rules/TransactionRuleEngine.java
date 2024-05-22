/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:11:21
 */

package app.banking.rules;

import app.framework.Account;
import app.framework.Entry;
import app.framework.Rule;

import java.util.ArrayList;
import java.util.List;

public class TransactionRuleEngine {

    private List<Rule> rules = new ArrayList<>();

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public void removeRule(Rule rule) {
        this.rules.remove(rule);
    }

    public List<Rule> getRules() {
        return this.rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public void process(Account account, Entry entry) {
        System.out.println("==== Applying rules ====");
        rules.stream()
                .filter(r -> r.matches(account, entry))
                .forEach(r -> r.apply(account, entry));
        System.out.println("==== Applied rules ====");
    }


}
