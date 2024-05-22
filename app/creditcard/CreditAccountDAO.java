package app.creditcard;

import app.framework.persistence.DAO;

public class CreditAccountDAO extends DAO<CreditAccount> {

    public CreditAccountDAO() {
        super("credit.store");
    }

}
