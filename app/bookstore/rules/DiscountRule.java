/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:12:20
 */

package app.bookstore.rules;

import app.bookstore.domain.BookStoreAccount;
import app.bookstore.domain.PurchaseEntry;
import app.framework.rules.Rule;

public interface DiscountRule extends Rule<BookStoreAccount, PurchaseEntry> {
}
