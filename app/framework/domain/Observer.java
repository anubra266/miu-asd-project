package app.framework.domain;

import java.io.Serializable;

public interface Observer extends Serializable {

    public static final long serialVersionUID = -891298765814574888L;

    void subscribe(Observable subject);
    void unsubscribe(Observable subject);
    void callback(Event event,Object ob);
}
