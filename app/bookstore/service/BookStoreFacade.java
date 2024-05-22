/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:13:02
 */

package app.bookstore.service;

import app.bookstore.domain.BookStoreAccount;
import app.bookstore.domain.PurchaseEntry;
import app.framework.facade.CommonFacade;

public interface BookStoreFacade extends CommonFacade<BookStoreAccount, PurchaseEntry> {
}
