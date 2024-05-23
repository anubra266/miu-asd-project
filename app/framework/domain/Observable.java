package app.framework.domain;

public interface Observable {
    void register(Observer ob);
    void unregister(Observer ob);
    void alert(Event event, Object ob);
}
