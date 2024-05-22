package app.framework.persistence;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DAO<T> implements Database<T>{
    Storage store;

    public DAO(String filename){
        String OUTPUT_DIR = String.join(
                File.separator,
                new String[]{System.getProperty("user.dir"),"app","framework","persistence", filename}
        );
        Path path = FileSystems.getDefault().getPath(OUTPUT_DIR);
        this.store = new Storage(path);
    }

     private HashMap<String, T> getMapData(){
        return (HashMap<String, T>) this.store.read();
    }

    @Override
    public void save(String id, T data) {
        HashMap<String, T> dataMap = (HashMap<String, T>) this.store.read();
        dataMap.put(id,data);
        this.store.save(dataMap);
    }

    @Override
    public void update(String id, T data) {
        this.save(id,data);
    }

    @Override
    public T get(String id) {
        HashMap<String, T> dataMap = this.getMapData();
        return dataMap.get(id);
    }

    @Override
    public Collection<T> getAll() {
        HashMap<String, T> dataMap = this.getMapData();
        ArrayList<T> data = new ArrayList<>();
        for(String id: dataMap.keySet()){
            data.add(dataMap.get(id));
        }
        return data;
    }
}
