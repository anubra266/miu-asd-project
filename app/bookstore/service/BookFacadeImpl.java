/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:15:14
 */

package app.bookstore.service;

import app.bookstore.domain.Book;
import app.framework.facade.CommonFacadeImpl;
import app.framework.persistence.DAO;
import app.framework.persistence.Database;

public class BookFacadeImpl extends CommonFacadeImpl<Book, String> implements BookFacade{

    public BookFacadeImpl(DAO<Book, String> database) {
        super(database);
    }
}
