/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:10:45
 */

package app.banking.rules;

import app.framework.domain.Account;
import app.framework.domain.Entry;
import app.framework.exceptions.InsufficientBalanceException;

public class CheckingAccountWithdrawRule implements TransactionRule {

    /**
     * Checks if the account has insufficient balance for the withdrawal amount.
     *
     * @param account the account to check.
     * @param entry   the transaction entry.
     * @return true if the account balance is less than the transaction amount, otherwise false.
     */

    @Override
    public boolean matches(Account account, Entry entry) {
        if(account.getBalance() < entry.getAmount()) return true;
        return false;
    }

    /**
     * Applies the rule, which throws an exception if the account balance is insufficient
     * @param account the account to check.
     * @param entry   the transaction entry.
     * @throws InsufficientBalanceException if the account balance is insufficient.
     */
    @Override
    public void apply(Account account, Entry entry) {
        throw new InsufficientBalanceException("Insufficient balance");
    }
}
