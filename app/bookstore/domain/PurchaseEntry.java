/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:12:23
 */

package app.bookstore.domain;

import app.framework.domain.Entry;

import java.time.LocalDateTime;

public class PurchaseEntry extends Entry {
    public PurchaseEntry(double amount, LocalDateTime date, String description) {
        super(amount, date, description);
    }

}
