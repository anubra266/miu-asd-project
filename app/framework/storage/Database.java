package app.framework.storage;

import java.util.Collection;

public interface Database<T> {
    void save(T account);
    void update(T account);
    T get(String accountNumber);
    Collection<T> getAll();
}