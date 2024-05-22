/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:13:32
 */

package app.bookstore.rules;

import app.bookstore.domain.BookStoreAccount;
import app.bookstore.domain.PurchaseEntry;
import app.framework.rules.Rule;

public interface NotificationRule extends Rule<BookStoreAccount, PurchaseEntry> {
}
