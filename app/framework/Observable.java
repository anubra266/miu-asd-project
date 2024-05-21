package app.framework;

public interface Observable {
    void register();
    void unregister();
    void alert();
}
