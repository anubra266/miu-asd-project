package app.framework.domain;

public interface Observer {
    void subscribe(Observable subject);
    void unsubscribe(Observable subject);
    void callback(Event event,Object ob);
}
