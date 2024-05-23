/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:13:33
 */

package app.bookstore.rules;

import app.bookstore.domain.BookStoreAccount;
import app.bookstore.domain.PurchaseEntry;
import app.framework.domain.Event;
import app.framework.domain.Observable;
import app.framework.domain.Observer;

import java.util.List;

public class EntryAmountNotificationRule extends NotificationRule {

    List<Observer> observers;
    public EntryAmountNotificationRule(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public boolean matches(BookStoreAccount bookStoreAccount, PurchaseEntry purchaseEntry) {
        return purchaseEntry.getAmount() > 400;
    }

    @Override
    public void apply(BookStoreAccount bookStoreAccount, PurchaseEntry purchaseEntry) {
        observers.forEach(e -> e.callback(Event.TRANSACTION_ALERT, "Purchase is more than 400"));
    }

    @Override
    public void register(Observer ob) {
        ob.subscribe(this);
    }

    @Override
    public void unregister(Observer ob) {
        ob.unsubscribe(this);
    }

    @Override
    public void alert(Event event, Object ob) {
        observers.forEach(e -> e.callback(event, ob));
    }
}
