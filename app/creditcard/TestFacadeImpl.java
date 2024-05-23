/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:14:58
 */

package app.creditcard;

import app.banking.domain.BankAccount;
import app.banking.domain.BankEntry;
import app.framework.domain.Observer;
import app.framework.facade.CommonBankFacadeImpl;
import app.framework.persistence.DAO;
import app.framework.persistence.Database;
import app.framework.rules.RuleEngine;
import java.util.List;

public class TestFacadeImpl extends CommonBankFacadeImpl<CreditAccount, BankEntry, String> implements TestFacade {
    public TestFacadeImpl(DAO<CreditAccount, String> database, RuleEngine<CreditAccount, BankEntry> ruleEngine, List<Observer> observers) {
        super(database, ruleEngine, observers);
    }
}
