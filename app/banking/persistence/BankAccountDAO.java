package app.banking.persistence;

import app.banking.domain.BankAccount;
import app.framework.persistence.DAO;

public class BankAccountDAO extends DAO<BankAccount, String> {

    private static BankAccountDAO instance = new BankAccountDAO();

    private BankAccountDAO() {
        super("bank.store");
    }

    public static BankAccountDAO getInstance(){
        return BankAccountDAO.instance;
    }

}
