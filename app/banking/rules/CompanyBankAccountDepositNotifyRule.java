/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.21
 * Time:14:42
 */
package app.banking.rules;

import app.banking.domain.BankAccount;
import app.framework.domain.Event;
import app.framework.domain.Observer;
import app.framework.domain.Subject;
import app.framework.rules.BankTransactionRule;

import java.util.List;

public class CompanyBankAccountDepositNotifyRule extends Subject implements BankTransactionRule {

    public CompanyBankAccountDepositNotifyRule(List<Observer> observerList) {
        if(observerList != null){
            observerList.stream().forEach(o -> o.subscribe(this));
        }
    }

    @Override
    public boolean matches(BankAccount account, Double amount, String desc, Event event) {
        return account.getCustomer().getCustomerType().equals("Company");
    }


    @Override
    public void apply(BankAccount account, Double amount, String desc, Event event) {
        this.alert(Event.DEPOSIT, account);
    }

    @Override
    public void alert(Event event, Object ob) {
        for(Observer obs: this.getObserverList()){
            obs.callback( event,  ob);
        }
    }
}
