package app.creditcard;

import app.framework.persistence.DAO;

public class CreditCardDAO extends DAO<CreditCardAccount> {

    public CreditCardDAO() {
        super("credit.store");
    }

}
