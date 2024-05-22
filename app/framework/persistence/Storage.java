package app.framework.persistence;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Storage {
    Path path;

    Storage(Path path){
        this.path = path;
        this.ensureFileExists();
    }

    private void ensureFileExists() {
        try {
            if (!Files.exists(this.path)) {
                // Ensure parent directories exist
                if (this.path.getParent() != null) {
                    Files.createDirectories(this.path.getParent());
                }
                // Create the file and write a default object
                Files.createFile(this.path);
                try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(this.path))) {
                    out.writeObject(null); // Writing a null object or default content
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object read() {

        Object retVal = null;
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(this.path))) {
            retVal = in.readObject();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public void save( Object ob ) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(this.path))) {
            out.writeObject(ob);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
