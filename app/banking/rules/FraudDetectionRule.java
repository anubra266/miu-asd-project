/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:10:52
 */

package app.banking.rules;

import app.framework.*;
import app.framework.exceptions.FraudTransactionException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class FraudDetectionRule implements TransactionRule {

    Observable observable;

    public FraudDetectionRule(Observable observable){
        this.observable  = observable;
    }

    @Override
    public boolean matches(Account account, Entry entry) {
        List<Entry> list = account.getEntryList();
        long count = list.stream()
                .filter(e -> {
                    LocalDateTime localDateTime = LocalDateTime.now();
                    LocalDateTime entryDate = entry.getDate();
                    Duration d = Duration.between(localDateTime, entryDate);
                    return d.toMinutes() <= 5 && entry.getAmount() == e.getAmount() && entry.getDescription().equals(e.getDescription());
                }).count();
        ;
        return count >= 3;
    }

    @Override
    public void apply(Account account, Entry entry) {
        observable.alert(Event.FRAUD_TRANSACTION_ALERT, account);
        throw new FraudTransactionException("Possible fraud transaction");
    }
}
