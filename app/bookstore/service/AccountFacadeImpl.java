/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:13:04
 */

package app.bookstore.service;

import app.bookstore.domain.Book;
import app.bookstore.domain.BookStoreAccount;
import app.bookstore.domain.PurchaseEntry;
import app.framework.domain.Account;
import app.framework.domain.Observer;
import app.framework.facade.CommonFacadeImpl;
import app.framework.persistence.DAO;
import app.framework.persistence.Database;
import app.framework.rules.RuleEngine;
import app.framework.facade.CommonBankFacadeImpl;

import java.util.List;

public class AccountFacadeImpl extends CommonFacadeImpl<BookStoreAccount, String> implements AccountFacade {

    public AccountFacadeImpl(DAO<BookStoreAccount, String> database) {
        super(database);
    }
}
