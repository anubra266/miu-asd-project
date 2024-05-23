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
import app.framework.persistence.Database;
import app.framework.rules.RuleEngine;

import java.util.List;

public class TestFacadeImpl extends CommonBankFacadeImpl<BankAccount, BankEntry, String> implements TestFacade {
    public TestFacadeImpl(Database<BankAccount, String> database, RuleEngine ruleEngine, List<Observer> observers) {
        super(database, ruleEngine, observers);
    }
}
