/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.21
 * Time:14:42
 */
package app.banking.rules;

import app.framework.domain.*;
import app.framework.rules.Rule;

import java.util.Arrays;
import java.util.List;

public class CompanyBankAccountWithdrawDepositRule extends Subject implements Rule<Account, Entry> {

    public CompanyBankAccountWithdrawDepositRule(List<Observer> observerList) {
        this.observerList = observerList;
    }

    /**
     * Checks if the account has negative balance after transaction and transaction amount is over 400 dollars.
     *
     * @param account the account to check.
     * @param entry   the transaction entry.
     * @return true if the account balance after transaction is less than zero or entry amount is over 400, otherwise false.
     */
    @Override
    public boolean matches(Account account, Entry entry) {
        Event[] validEvents = {Event.WITHDRAW, Event.DEPOSIT};
        return account.getCustomer().getCustomerType().equals("Company") && Arrays.stream(validEvents).anyMatch(e -> e.equals(entry.getEvent()));
    }

    /**
     * Applies the rule, which alerts an observable.
     * @param account the account to check.
     * @param entry   the transaction entry.
     */
    @Override
    public void apply(Account account, Entry entry) {
        this.alert(entry.getEvent(), account);
    }

    @Override
    public void alert(Event event, Object ob) {
        for(Observer obs: this.observerList){
            obs.callback( event,  ob);
        }
    }
}
