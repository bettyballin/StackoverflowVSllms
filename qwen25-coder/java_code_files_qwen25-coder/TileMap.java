import java.util.ArrayList;
import java.util.List;

public class TileMap {
    private final int mapWidth; // Width in tiles
    private final int mapHeight; // Height in tiles
    private final int tileWidth; // Width of each tile in pixels
    private final int tileHeight; // Height of each tile in pixels
    private final boolean[][] occupiedTiles; // Each true value represents an occupied tile

    public TileMap(int width, int height, int tileWidth, int tileHeight) {
        this.mapWidth = width;
        this.mapHeight = height;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        // Initialize the map with unoccupied tiles (false)
        this.occupiedTiles = new boolean[width][height];
    }

    public void setTileOccupied(int x, int y, boolean occupied) {
        if (isValidCoordinate(x, y)) {
            occupiedTiles[x][y] = occupied;
        }
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < mapWidth && y >= 0 && y < mapHeight;
    }

    public Tile getTileFromCoordinates(int xPixel, int yPixel) {
        // Calculate tile index based on pixel coordinates
        int x = xPixel / tileWidth;
        int y = yPixel / tileHeight;

        if (isValidCoordinate(x, y)) {
            return new Tile(x, y, occupiedTiles[x][y]);
        }
        return null; // Out of bounds
    }

    public List<int[]> getCoordinatesFromTile(int xTileIndex, int yTileIndex) {
        // Calculate pixel coordinates based on tile index
        if (isValidCoordinate(xTileIndex, yTileIndex)) {
            List<int[]> coordinates = new ArrayList<>();
            for (int dy = 0; dy < tileHeight; dy++) {
                for (int dx = 0; dx < tileWidth; dx++) {
                    int xPixel = xTileIndex * tileWidth + dx;
                    int yPixel = yTileIndex * tileHeight + dy;
                    if (isValidPixel(xPixel, yPixel)) {
                        coordinates.add(new int[]{xPixel, yPixel});
                    }
                }
            }
            return coordinates;
        }
        return null; // Out of bounds
    }

    private boolean isValidPixel(int x, int y) {
        return x >= 0 && x < mapWidth * tileWidth && y >= 0 && y < mapHeight * tileHeight;
    }

    public boolean isTileOccupied(int x, int y) {
        if (isValidCoordinate(x, y)) {
            return occupiedTiles[x][y];
        }
        return true; // Out of bounds tiles considered as occupied
    }

    static class Tile {
        private final int x;
        private final int y;
        private final boolean occupied;

        public Tile(int x, int y, boolean occupied) {
            this.x = x;
            this.y = y;
            this.occupied = occupied;
        }
        
        // Getter methods
        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isOccupied() {
            return occupied;
        }
    }

    public static void main(String[] args) {
        TileMap map = new TileMap(400 / 4, 400 / 4, 4, 4);

        // Example: Occupying a tile (5th tile from left and bottom)
        map.setTileOccupied(5, 3, true);
        
        // Check if a tile is occupied
        Tile tile = map.getTileFromCoordinates(21, 15); // Should return the same as (5,3) tile
        System.out.println("Tile at pixel (21,15) is occupied: " + tile.isOccupied());

        List<int[]> coordinates = map.getCoordinatesFromTile(5, 3);
        for (int[] coordinate : coordinates) {
            System.out.printf("Tile (%d,%d) corresponds to pixels (%d,%d)\n", 5, 3, coordinate[0], coordinate[1]);
        }

        // Check for boundaries and collision
        System.out.println("Is tile (25,25) occupied? " + map.isTileOccupied(25, 25)); // Should be false unless set true
    }
}