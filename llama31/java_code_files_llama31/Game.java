/*
 * Decompiled with CFR 0.152.
 */
public class Game {
    public static void main(String[] stringArray) {
        TileMap tileMap = new TileMap(400, 400);
        int n = tileMap.getTileIndex(120, 300);
        int[] nArray = tileMap.getTileCoordinates(n);
        System.out.println("Tile Index: " + n);
        System.out.println("Tile Coordinates: " + nArray[0] + ", " + nArray[1]);
    }
}
