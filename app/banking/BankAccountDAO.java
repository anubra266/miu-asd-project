package app.banking;

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
