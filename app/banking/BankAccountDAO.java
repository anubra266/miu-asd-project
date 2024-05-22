package app.banking;

import app.framework.persistence.DAO;

public class BankAccountDAO extends DAO<BankAccount> {

    public BankAccountDAO() {
        super("bank.store");
    }

}
