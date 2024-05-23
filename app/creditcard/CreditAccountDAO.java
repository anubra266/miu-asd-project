package app.creditcard;

import app.framework.persistence.DAO;

public class CreditAccountDAO extends DAO<CreditAccount, String> {
    private static CreditAccountDAO instance = new CreditAccountDAO();

    private CreditAccountDAO() {
        super("credit.store");
    }

    public static CreditAccountDAO getInstance(){
        return CreditAccountDAO.instance;
    }

}
