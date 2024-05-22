/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:12:54
 */

package app.framework.rules;

import app.framework.domain.Account;
import app.framework.domain.Entry;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
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
