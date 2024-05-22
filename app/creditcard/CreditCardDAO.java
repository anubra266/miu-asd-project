package app.creditcard;

import app.framework.storage.DAO;

public class CreditCardDAO extends DAO<CreditCardAccount> {

    public CreditCardDAO() {
        super("credit.store");
    }

}
