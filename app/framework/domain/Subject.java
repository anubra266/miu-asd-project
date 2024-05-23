package app.framework.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject implements Observable{
    protected List<Observer> observerList = new ArrayList<>();

    @Override
    public void register(Observer ob) {
        this.observerList.add(ob);
    }

    @Override
    public void unregister(Observer ob) {
        this.observerList.remove(ob);
    }

    public List<Observer> getObserverList() {
        return this.observerList;
    }
}