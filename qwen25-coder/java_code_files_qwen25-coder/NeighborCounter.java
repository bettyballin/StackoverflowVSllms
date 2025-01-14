import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Objects;

class Voxel {
    int x, y, z;
    
    Voxel(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voxel)) return false;
        Voxel voxel = (Voxel) o;
        return x == voxel.x && y == voxel.y && z == voxel.z;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

public class NeighborCounter {
    private static final int[] NEIGHBOR_DIRECTIONS = {
        -1, 0, 0, 1, 0, 0,
        0, -1, 0, 0, 1, 0,
        0, 0, -1, 0, 0, 1
    };
    
    public static Map<Voxel, Integer> countNeighbors(Set<Voxel> filledVoxels) {
        Map<Voxel, Integer> neighborCount = new HashMap<>();
        
        for (Voxel v : filledVoxels) {
            if (!neighborCount.containsKey(v)) {
                neighborCount.put(v, 0);
            }
            
            for (int i = 0; i < NEIGHBOR_DIRECTIONS.length; i += 3) {
                int nx = v.x + NEIGHBOR_DIRECTIONS[i];
                int ny = v.y + NEIGHBOR_DIRECTIONS[i + 1];
                int nz = v.z + NEIGHBOR_DIRECTIONS[i + 2];
                
                Voxel neighbor = new Voxel(nx, ny, nz);
                
                if (filledVoxels.contains(neighbor)) {
                    neighborCount.put(v, neighborCount.get(v) + 1);
                    if (!neighborCount.containsKey(neighbor)) {
                        neighborCount.put(neighbor, 0);
                    }
                    neighborCount.put(neighbor, neighborCount.get(neighbor) + 1);
                }
            }
        }
        
        return neighborCount;
    }

    public static void main(String[] args) {
        Set<Voxel> filledVoxels = new HashSet<>();
        filledVoxels.add(new Voxel(1, 1, 1));
        filledVoxels.add(new Voxel(1, 2, 1));
        filledVoxels.add(new Voxel(1, 3, 1));

        Map<Voxel, Integer> neighborCounts = countNeighbors(filledVoxels);

        for (Map.Entry<Voxel, Integer> entry : neighborCounts.entrySet()) {
            System.out.println("Voxel " + entry.getKey() + " has " + entry.getValue() + " neighbors.");
        }
    }
}