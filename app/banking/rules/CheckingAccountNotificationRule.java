/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.21
 * Time:14:42
 */
package app.banking.rules;

import app.framework.*;

public class CheckingAccountNotificationRule implements TransactionRule {

    Observable observable;

    public CheckingAccountNotificationRule(Observable observable) {
        this.observable = observable;
    }

    /**
     * Checks if the account has negative balance after transaction and transaction amount is over 400 dollars.
     *
     * @param account the account to check.
     * @param entry   the transaction entry.
     * @return true if the account balance after transaction is less than zero or entry amount is over 400, otherwise false.
     */
    @Override
    public boolean matches(Account account, Entry entry) {
        return account.getBalance() - entry.getAmount() < 0 || entry.getAmount() > 400;
    }

    /**
     * Applies the rule, which alerts an observable.
     * @param account the account to check.
     * @param entry   the transaction entry.
     */
    @Override
    public void apply(Account account, Entry entry) {
        observable.alert(Event.TRANSACTION_ALERT, account);
    }
}
