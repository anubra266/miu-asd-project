/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:10:52
 */

package app.banking.rules;

import app.banking.domain.BankAccount;
import app.framework.exceptions.FraudTransactionException;
import app.framework.domain.*;
import app.framework.rules.BankTransactionRule;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class FraudDetectionRule extends Subject implements BankTransactionRule {

    public FraudDetectionRule(List<Observer> observerList){
        if(observerList != null){
            observerList.stream().forEach(o -> o.subscribe(this));
        }
    }

    @Override
    public boolean matches(BankAccount account, Double amount, String desc, Event event) {
        List<Entry> list = account.getEntryList();
        long count = list.stream()
                .filter(e -> {
                    LocalDateTime localDateTime = LocalDateTime.now();
                    LocalDateTime entryDate = e.getDate();
                    Duration d = Duration.between(localDateTime, entryDate);
                    return d.toMinutes() <= 5 && amount == e.getAmount();
                }).count();
        return count >= 3;
    }

    @Override
    public void apply(BankAccount acc, Double amount, String desc, Event event) {
        this.alert(Event.FRAUD_TRANSACTION_ALERT, acc);
        throw new FraudTransactionException("Possible fraud transaction");
    }

    @Override
    public void alert(Event event, Object ob) {
        for(Observer obs: this.getObserverList()){
            obs.callback( event,  ob);
        }
    }
}
