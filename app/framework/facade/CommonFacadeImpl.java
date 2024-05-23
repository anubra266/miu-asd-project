/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.22
 * Time:14:32
 */

package app.framework.facade;

import app.framework.persistence.DAO;
import app.framework.persistence.Database;

import java.util.Collection;

public abstract class CommonFacadeImpl<R, I> implements CommonFacade<R, I> {

    protected DAO<R, I> database;

    public CommonFacadeImpl(DAO<R, I> database) {
        this.database = database;
    }

    public Database<R, I> getDatabase() {
        return this.database;
    }

    @Override
    public R create(I i, R r) {
        database.save(i, r);
        return r;
    }

    @Override
    public R update(I i, R r) {
        database.update(i, r);
        return r;
    }

    @Override
    public void delete(I i) {
        database.delete(i);
    }

    @Override
    public Collection<R> findAll() {
        return database.getAll();
    }

    @Override
    public long count() {
        return database.getAll().stream().count();
    }
}
