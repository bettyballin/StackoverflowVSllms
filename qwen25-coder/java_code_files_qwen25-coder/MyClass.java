import java.util.zip.GZIPOutputStream;
import java.util.zip.GZIPInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class MyClass {

    public void saveCompressed(GameState gameState) {
        try (GZIPOutputStream gzos = new GZIPOutputStream(new FileOutputStream("savegame.gz"))) {
            ObjectOutputStream oos = new ObjectOutputStream(gzos);
            oos.writeObject(gameState);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class GameState implements java.io.Serializable {
    // Empty class to allow compilation
}