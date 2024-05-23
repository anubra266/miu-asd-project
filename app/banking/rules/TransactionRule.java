/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.21
 * Time:14:37
 */

package app.banking.rules;

import app.framework.domain.Account;
import app.framework.domain.Entry;
import app.framework.rules.Rule;

public interface TransactionRule extends Rule<Account, Entry> {
}
