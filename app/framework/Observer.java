package app.framework;

public interface Observer {
    void subscribe(Observable subject);
    void unsubscribe(Observable subject);
    void callback();
}
