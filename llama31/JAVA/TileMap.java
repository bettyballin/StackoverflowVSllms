import java.lang.String;
import java.lang.Set;

public class TileMap {
    private int[][] map;
    private int tileSize = 4;
    private int width;
    private int height;

    public TileMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new int[width / tileSize][height / tileSize];
    }

    // Convert x, y coordinates to tile index
    public int getTileIndex(int x, int y) {
        int tileX = x / tileSize;
        int tileY = y / tileSize;
        return tileY * (width / tileSize) + tileX;
    }

    // Convert tile index to x, y coordinates
    public int[] getTileCoordinates(int index) {
        int tileX = index % (width / tileSize);
        int tileY = index / (width / tileSize);
        return new int[] { tileX * tileSize, tileY * tileSize };
    }

    // Check if a tile is vacant
    public boolean isTileVacant(int index) {
        int[] coordinates = getTileCoordinates(index);
        int tileX = coordinates[0] / tileSize;
        int tileY = coordinates[1] / tileSize;
        return map[tileX][tileY] == 0;
    }

    // Set a tile as occupied
    public void setTileOccupied(int index) {
        int[] coordinates = getTileCoordinates(index);
        int tileX = coordinates[0] / tileSize;
        int tileY = coordinates[1] / tileSize;
        map[tileX][tileY] = 1;
    }

    // Clear a tile
    public void clearTile(int index) {
        int[] coordinates = getTileCoordinates(index);
        int tileX = coordinates[0] / tileSize;
        int tileY = coordinates[1] / tileSize;
        map[tileX][tileY] = 0;
    }

	public static void main(String[] args) {
        // Example usage
        TileMap tileMap = new TileMap(16, 16);
        int index = tileMap.getTileIndex(8, 8);
        System.out.println("Tile index: " + index);
        int[] coordinates = tileMap.getTileCoordinates(index);
        System.out.println("Tile coordinates: (" + coordinates[0] + ", " + coordinates[1] + ")");
        System.out.println("Is tile vacant? " + tileMap.isTileVacant(index));
        tileMap.setTileOccupied(index);
        System.out.println("Is tile vacant after occupation? " + tileMap.isTileVacant(index));
        tileMap.clearTile(index);
        System.out.println("Is tile vacant after clearing? " + tileMap.isTileVacant(index));
	}
}