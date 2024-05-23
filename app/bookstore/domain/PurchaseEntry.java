/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:12:23
 */

package app.bookstore.domain;

import app.framework.domain.Entry;
import app.framework.domain.Event;

import java.time.LocalDateTime;

public class PurchaseEntry extends Entry {
    public PurchaseEntry(double amount, LocalDateTime date, String description, Event event) {
        super(amount, date, description,event);
    }
}
