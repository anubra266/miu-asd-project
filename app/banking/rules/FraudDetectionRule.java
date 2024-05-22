/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:10:52
 */

package app.banking.rules;

import app.framework.Account;
import app.framework.Entry;
import app.framework.Rule;
import app.framework.TransactionRule;

public class FraudDetectionRule implements TransactionRule {
    @Override
    public boolean matches(Account account, Entry entry) {

        return false;
    }

    @Override
    public void apply(Account account, Entry entry) {

    }
}
