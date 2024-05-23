/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:14:57
 */

package app.creditcard;

import app.banking.domain.BankAccount;
import app.banking.domain.BankEntry;
import app.framework.facade.CommonBankFacade;

public interface TestFacade extends CommonBankFacade<CreditAccount, BankEntry, String> {
}
