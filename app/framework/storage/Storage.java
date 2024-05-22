package app.framework.storage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Storage {
    Path path;
    
    Storage(Path path){
        this.path = path;
    }

    public Object read() {
        ObjectInputStream in = null;
        Object retVal = null;
        try {
            in = new ObjectInputStream(Files.newInputStream(this.path));
            retVal = in.readObject();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch(Exception e) {}
            }
        }
        return retVal;
    }

    public void save( Object ob ) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(Files.newOutputStream(this.path));
            out.writeObject(ob);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch(Exception e) {}
            }
        }
    }
}
