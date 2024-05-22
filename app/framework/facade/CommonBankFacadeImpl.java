/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:12:34
 */

package app.framework.facade;

import app.framework.domain.*;
import app.framework.persistence.Database;
import app.framework.rules.RuleEngine;

import java.util.List;

public abstract class CommonBankFacadeImpl<R extends Account, T extends Entry, I> extends CommonFacadeImpl<R,I> implements CommonBankFacade<R, T, I>, Observable {

    Database<R, I> database;
    RuleEngine ruleEngine;

    List<Observer> observers;

    public CommonBankFacadeImpl(Database<R, I> database, RuleEngine ruleEngine, List<Observer> observers) {
        super(database);
        this.database = database;
        this.ruleEngine = ruleEngine;
        this.observers = observers;
        observers.stream().forEach(e -> e.subscribe(this));
    }


    @Override
    public void deposit(R r, T t) {
        try {
            this.ruleEngine.process(r, t);
            r.deposit(t.getAmount(), t.getDescription());
            database.update((I) r.getAccNumber(), r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void withdraw(R r, T t) {
        try {
            this.ruleEngine.process(r, t);
            r.withdraw(t.getAmount(), t.getDescription());
            database.update((I) r.getAccNumber(), r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public R update(I id, R r) {
        database.update((I) r.getAccNumber(), r);
        return r;
    }

    @Override
    public void addInterest() {
        database.getAll().forEach(Account::addInterest);
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
