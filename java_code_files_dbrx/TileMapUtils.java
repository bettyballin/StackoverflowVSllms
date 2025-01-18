import java.lang.String;
public class TileMapUtils {
    public static final int TILE_SIZE = 32;
    public static final int MAP_HEIGHT = 20;
    
    public int getIndexFromPosition(int x, int y) {
        return (y / TILE_SIZE) * MAP_HEIGHT + (x / TILE_SIZE);
    }
    
    public static void main(String[] args) {
    }
}