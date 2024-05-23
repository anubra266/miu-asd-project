/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:13:02
 */

package app.bookstore.rules;

import app.bookstore.domain.BookStoreAccount;
import app.bookstore.domain.PurchaseEntry;

public class LoyalCustomerDiscountRule implements DiscountRule{
    @Override
    public boolean matches(BookStoreAccount bookStoreAccount, PurchaseEntry purchaseEntry) {
        long count = bookStoreAccount.getEntryList().stream().count();
        return count >= 10;
    }

    @Override
    public void apply(BookStoreAccount bookStoreAccount, PurchaseEntry purchaseEntry) {
        // TODO: Apply discount on the entry

        PurchaseEntry discountedEntry = new PurchaseEntry(purchaseEntry.getAmount() - purchaseEntry.getAmount() * .1 , purchaseEntry.getDate(), purchaseEntry.getDescription()+ "Note: 10% off from loyal customers",purchaseEntry.getEvent());
        bookStoreAccount.getEntryList().add(discountedEntry);



    }
}
