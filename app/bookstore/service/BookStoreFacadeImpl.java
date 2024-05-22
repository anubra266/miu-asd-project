/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:13:04
 */

package app.bookstore.service;

import app.bookstore.domain.BookStoreAccount;
import app.bookstore.domain.PurchaseEntry;
import app.framework.domain.Observer;
import app.framework.persistence.Database;
import app.framework.rules.RuleEngine;
import app.framework.facade.CommonFacadeImpl;

import java.util.List;

public class BookStoreFacadeImpl extends CommonFacadeImpl<BookStoreAccount, PurchaseEntry> implements BookStoreFacade {

    public BookStoreFacadeImpl(Database<BookStoreAccount> database, RuleEngine ruleEngine, List<Observer> observerList) {
        super(database, ruleEngine, observerList);

    }
}
