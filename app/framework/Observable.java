package app.framework;

public interface Observable {
    void register(Observer ob);
    void unregister(Observer ob);
    void alert();
}
