/*
 * Decompiled with CFR 0.152.
 */
public class PacmanCollisionDetector {
    public static void main(String[] stringArray) {
        int[][] nArrayArray = new int[][]{{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {1, 1, 1, 0}};
        int n = 40;
        int n2 = 20;
        if (nArrayArray[n / 20][n2 / 20] == 1) {
            System.out.println("Pacman has collided with a wall");
        }
    }
}
