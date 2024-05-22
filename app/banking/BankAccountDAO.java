package app.banking;

import app.framework.storage.DAO;

public class BankAccountDAO extends DAO<BankAccount> {

    public BankAccountDAO() {
        super("bank.store");
    }

}
