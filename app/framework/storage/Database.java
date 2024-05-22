package app.framework.storage;

import java.util.Collection;

public interface Database<T> {
    void save(String id, T data);
    void update(String id, T data);
    T get(String id);
    Collection<T> getAll();
}