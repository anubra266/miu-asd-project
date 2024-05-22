package app.framework.persistence;

import java.util.Collection;

public interface Database<T> {
    boolean isUnique(String id);
    void save(String id, T data);
    void update(String id, T data);
    T get(String id);
    Collection<T> getAll();
}