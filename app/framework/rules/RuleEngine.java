/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:12:54
 */

package app.framework.rules;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine<T,I> {
    private List<Rule<T,I>> rules = new ArrayList<>();

    public void addRule(Rule<T,I> rule) {
        this.rules.add(rule);
    }

    public void removeRule(Rule<T,I> rule) {
        this.rules.remove(rule);
    }

    public List<Rule<T,I>> getRules() {
        return this.rules;
    }

    public void setRules(List<Rule<T,I>> rules) {
        this.rules = rules;
    }

    public void process(T arg1, I arg2) {
        System.out.println("==== Applying rules ====");
        rules.stream()
                .filter(r -> r.matches(arg1, arg2))
                .forEach(r -> r.apply(arg1, arg2));
        System.out.println("==== Applied rules ====");
    }

}
