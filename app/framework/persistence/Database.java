package app.framework.persistence;

import java.util.Collection;

public interface Database<T, I> {
    boolean isUnique(I id);
    void save(I id, T data);
    void update(I id, T data);
    T get(I id);
    Collection<T> getAll();
    void delete(I id);
}