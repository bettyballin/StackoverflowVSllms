import java.lang.String;
public class LightRayTracing {
    private static final int MAX_LIGHT_RADIUS = 8; // maximum distance light can travel

    public void traceLight(int[][] map, int lightX, int lightY) {
        int width = map.length;
        int height = map[0].length;

        for (int angle = 0; angle < 360; angle++) {
            double radians = Math.toRadians(angle);
            for (int distance = 1; distance <= MAX_LIGHT_RADIUS; distance++) {
                int x = (int) Math.round(lightX + Math.cos(radians) * distance);
                int y = (int) Math.round(lightY + Math.sin(radians) * distance);

                if (x < 0 || x >= width || y < 0 || y >= height)
                    break;

                // Mark tile as lit
                map[x][y] = 1; // or increase light level

                // Break the ray if it hits an obstacle
                if (map[x][y] == 'X')
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[][] map = {
                {0, 0, 0, 0, 0, 0, '-', '-', 0},
                {0, 0, 0, 0, 0, 0, '-', 0, 0},
                {0, 0, 0, 0, 0, 'X', 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 'L', 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 'X', 'X', 'X', 'X', 0, 0},
                {0, 0, 0, '-', '-', '-', '-', '-', 0},
                {0, 0, '-', '-', '-', '-', '-', '-', '-'},
        };

        // Assuming the light source is at position (4, 4)
        LightRayTracing rayTracer = new LightRayTracing();
        rayTracer.traceLight(map, 4, 4);

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                System.out.print((map[x][y] == 1 ? '0' : map[x][y]) + " ");
            }
            System.out.println();
        }
    }
}