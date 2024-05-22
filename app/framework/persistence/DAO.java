package app.framework.persistence;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DAO<T, I> implements Database<T, I> {
    Storage store;

    public DAO(String filename) {
        String OUTPUT_DIR = String.join(
                File.separator,
                new String[] { System.getProperty("user.dir"), "app", "framework", "persistence", filename });
        Path path = FileSystems.getDefault().getPath(OUTPUT_DIR);
        this.store = new Storage(path);
    }

    @Override
    public boolean isUnique(I id) {
        HashMap<I, T> dataMap = (HashMap<I, T>) this.store.read();
        if (dataMap == null)
            return true;
        return !dataMap.containsKey(id);
    }

    @Override
    public void save(I id, T data) {
        HashMap<I, T> dataMap = (HashMap<I, T>) this.store.read();
        if (dataMap == null)
            dataMap = new HashMap<>();
        dataMap.put(id, data);
        this.store.save(dataMap);
    }

    @Override
    public void update(I id, T data) {
        this.save(id, data);
    }

    @Override
    public T get(I id) {
        HashMap<I, T> dataMap = this.getMapData();
        if (dataMap == null)
            dataMap = new HashMap<>();
        return dataMap.get(id);
    }

    @Override
    public Collection<T> getAll() {
        HashMap<I, T> dataMap = this.getMapData();
        if (dataMap == null)
            dataMap = new HashMap<>();
        ArrayList<T> data = new ArrayList<>();
        for (I id : dataMap.keySet()) {
            data.add(dataMap.get(id));
        }
        return data;
    }

    @Override
    public void delete(I id) {
        HashMap<I, T> dataMap = this.getMapData();
        dataMap.remove(id);
    }

    private HashMap<I, T> getMapData() {
        return (HashMap<I, T>) this.store.read();
    }
}
