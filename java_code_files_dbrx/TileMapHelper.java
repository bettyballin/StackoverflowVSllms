import java.lang.String;
import java.awt.Point;

public class TileMapHelper {
    private static final int MAP_WIDTH = 10;
    private static final int TILE_SIZE = 32;

    public Point getPositionFromIndex(int index) {
        return new Point((index % MAP_WIDTH) * TILE_SIZE, (index / MAP_WIDTH) * TILE_SIZE);
    }

    public static void main(String[] args) {
    }
}