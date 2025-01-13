/*
 * Decompiled with CFR 0.152.
 */
class TileMap {
    private int width;
    private int height;

    public TileMap(int n, int n2) {
        this.width = n;
        this.height = n2;
    }

    public int getTileIndex(int n, int n2) {
        int n3 = n / 10;
        int n4 = n2 / 10;
        return n4 * (this.width / 10) + n3;
    }

    public int[] getTileCoordinates(int n) {
        int n2 = n % (this.width / 10);
        int n3 = n / (this.width / 10);
        return new int[]{n2 * 10, n3 * 10};
    }
}
