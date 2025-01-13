import java.lang.String;

class TileMap {
    private int width;
    private int height;

    public TileMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getTileIndex(int x, int y) {
        // assuming each tile is 10x10 pixels
        int tileX = x / 10;
        int tileY = y / 10;
        return tileY * (width / 10) + tileX;
    }

    public int[] getTileCoordinates(int tileIndex) {
        int tileX = tileIndex % (width / 10);
        int tileY = tileIndex / (width / 10);
        return new int[]{tileX * 10, tileY * 10};
    }
}

public class Game {
    public static void main(String[] args) {
        TileMap map = new TileMap(400, 400);
        int tileIndex = map.getTileIndex(120, 300);
        int[] coordinates = map.getTileCoordinates(tileIndex);
        System.out.println("Tile Index: " + tileIndex);
        System.out.println("Tile Coordinates: " + coordinates[0] + ", " + coordinates[1]);
    }
}