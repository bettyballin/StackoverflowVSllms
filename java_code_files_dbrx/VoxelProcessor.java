import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class VoxelProcessor {

    Map<Voxel, Integer> voxelCounts = new HashMap<>();
    Set<Voxel> filledVoxels = new HashSet<>();
    Set<Voxel> visitedVoxels = new HashSet<>(); // Initialize empty hash set here before the main loop

    int checkAllNeighbours(Voxel current) {
        int voxelCount_current = 0;
        for (Direction direction : Direction.values()) { // assuming you have a predefined way to identify all neighbors in this step.
            Voxel neighbor = getNeighborInDirection(current, direction); // implement this function that gets the current neighbor according to the direction/offset

            if (neighbor != null && visitedVoxels.contains(neighbor)) {
                Integer count = voxelCounts.get(neighbor); // updating count from existing neighbors' counts, if already calculated before. No need for new lookup or search in filledVoxels set anymore.
                if (count != null) {
                    voxelCount_current += count;
                }
            } else if (neighbor != null && filledVoxels.contains(neighbor)) {
                visitedVoxels.add(neighbor);  // mark this neighboring voxel as 'visited' since we are about to calculate its count from now. Adds it into HashSet for efficient further lookups on neighbors
                int neighborCount = checkAllNeighbours(neighbor); // Recursively calculate neighbor counting and update current voxel's total count.
                voxelCount_current += neighborCount;
                voxelCounts.put(neighbor, neighborCount);
            }
        }
        voxelCounts.put(current, voxelCount_current);
        return voxelCount_current;
    }

    Voxel getNeighborInDirection(Voxel current, Direction direction) {
        int newX = current.x + direction.dx();
        int newY = current.y + direction.dy();
        int newZ = current.z + direction.dz();

        if (isInsideGrid(newX, newY, newZ)) {
            return new Voxel(newX, newY, newZ);
        } else {
            return null;
        }
    }

    boolean isInsideGrid(int x, int y, int z) {
        // Define your grid boundaries here
        int gridSize = 100; // Example grid size
        return x >= 0 && x < gridSize &&
               y >= 0 && y < gridSize &&
               z >= 0 && z < gridSize;
    }

    // Additional methods and initialization as needed
}

class Voxel {
    int x, y, z;

    public Voxel(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    // Override equals and hashCode for proper functionality in collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voxel voxel = (Voxel) o;

        if (x != voxel.x) return false;
        if (y != voxel.y) return false;
        return z == voxel.z;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }
}

enum Direction {
    // All 26 possible directions in a 3D grid (excluding the center voxel)
    D1(-1, -1, -1),
    D2(-1, -1, 0),
    D3(-1, -1, 1),
    D4(-1, 0, -1),
    D5(-1, 0, 0),
    D6(-1, 0, 1),
    D7(-1, 1, -1),
    D8(-1, 1, 0),
    D9(-1, 1, 1),
    D10(0, -1, -1),
    D11(0, -1, 0),
    D12(0, -1, 1),
    D13(0, 0, -1),
    D14(0, 0, 1),
    D15(0, 1, -1),
    D16(0, 1, 0),
    D17(0, 1, 1),
    D18(1, -1, -1),
    D19(1, -1, 0),
    D20(1, -1, 1),
    D21(1, 0, -1),
    D22(1, 0, 0),
    D23(1, 0, 1),
    D24(1, 1, -1),
    D25(1, 1, 0),
    D26(1, 1, 1);

    private final int dx;
    private final int dy;
    private final int dz;

    Direction(int dx, int dy, int dz) {
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }

    public int dz() {
        return dz;
    }
}