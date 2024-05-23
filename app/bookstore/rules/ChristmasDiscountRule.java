/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:13:01
 */

package app.bookstore.rules;

import app.bookstore.domain.BookStoreAccount;
import app.bookstore.domain.PurchaseEntry;

import java.time.LocalDateTime;
import java.time.Month;

public class ChristmasDiscountRule implements DiscountRule {
    @Override
    public boolean matches(BookStoreAccount bookStoreAccount, PurchaseEntry purchaseEntry) {
        LocalDateTime now = LocalDateTime.now();
        return now.getMonth() == Month.DECEMBER && now.getDayOfMonth() == 25;

    }

    @Override
    public void apply(BookStoreAccount bookStoreAccount, PurchaseEntry purchaseEntry) {
        // TODO: apply some discount on entry amount
        PurchaseEntry discountedEntry = new PurchaseEntry(purchaseEntry.getAmount() - purchaseEntry.getAmount() * .1 , purchaseEntry.getDate(), purchaseEntry.getDescription()+ "Note: 10% off from during Christmas", purchaseEntry.getEvent());
        bookStoreAccount.getEntryList().add(discountedEntry);

    }
}
