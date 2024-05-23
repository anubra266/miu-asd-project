package app.framework.facade;
import app.framework.domain.Account;
import app.framework.persistence.DAO;
import app.framework.persistence.Database;
import app.framework.rules.BankRuleEngine;
import app.framework.rules.RuleEngine;


public class BankFacadeImpl extends CommonFacadeImpl<Account,String> implements BankFacade<Account,Double,String> {

    RuleEngine<Account,Double> ruleEngine;

    public BankFacadeImpl(DAO<Account,String> database, BankRuleEngine ruleEngine) {
        super(database);
        this.ruleEngine = ruleEngine;
    }

    @Override
    public void withdraw(String accNumber, Double amount) {
        try {
            Account acc = this.getDatabase().get(accNumber);
            this.ruleEngine.process(acc,amount);
            acc.withdraw(amount, "Amount WithDraw");
            this.getDatabase().update(acc.getAccNumber(), acc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposit(String accNumber, Double amount) {
        try {
            Account acc = this.getDatabase().get(accNumber);
            this.ruleEngine.process(acc,amount);
            acc.deposit(amount,"Amount Deposit");
            this.getDatabase().update(acc.getAccNumber(), acc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addInterest() {
        this.getDatabase().getAll().forEach(Account::addInterest);
    }

    public Account update(String id, Account acc) {
        this.getDatabase().update(id, acc);
        return acc;
    }

}
