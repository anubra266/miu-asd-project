/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:12:34
 */

package app.framework.facade;

import app.framework.domain.*;
import app.framework.persistence.DAO;
import app.framework.rules.RuleEngine;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonBankFacadeImpl<R extends Account, T extends Entry, I> extends CommonFacadeImpl<R,I> implements CommonBankFacade<R, T, I>, Observable {

    RuleEngine<R,T> ruleEngine;

    List<Observer> observers = new ArrayList<>();

    public CommonBankFacadeImpl(DAO<R, I> database, RuleEngine<R,T> ruleEngine, List<Observer> observers) {
        super(database);
        this.ruleEngine = ruleEngine;
        if(observers != null){
            observers.stream().forEach(e -> e.subscribe(this));
        }

    }

    public RuleEngine<R, T> getRuleEngine() {
        return this.ruleEngine;
    }

    public List<Observer> getObservers() {
        return this.observers;
    }

    @Override
    public void deposit(R r, T t) {
        try {
            this.ruleEngine.process(r, t);
            r.deposit(t.getAmount(), t.getDescription());
            this.getDatabase().update((I) r.getAccNumber(), r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void withdraw(R r, T t) {
        try {
            this.ruleEngine.process(r, t);
            r.withdraw(t.getAmount(), t.getDescription());
            this.getDatabase().update((I) r.getAccNumber(), r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public R update(I id, R r) {
        this.getDatabase().update((I) r.getAccNumber(), r);
        return r;
    }

    @Override
    public void addInterest() {
        this.getDatabase().getAll().forEach(Account::addInterest);
    }

    @Override
    public void register(Observer ob) {
        this.observers.add(ob);
    }

    @Override
    public void unregister(Observer ob) {
        this.observers.remove(ob);
    }

    @Override
    public void alert(Event event, Object ob) {
        this.observers.forEach(e -> e.callback(event, ob));
    }
}
