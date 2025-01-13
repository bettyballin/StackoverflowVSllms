import java.util.*;

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
        if (o == null || getClass() != o.getClass()) return false;
        Voxel voxel = (Voxel) o;
        return x == voxel.x && y == voxel.y && z == voxel.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}

public class Main_381_381 {
    public static void main(String[] args) {
        Set<Voxel> filledVoxels = new HashSet<>();
        // ... populate filledVoxels ...

        Map<Voxel, Integer> voxelCount = new HashMap<>();
        for (Voxel v : filledVoxels) {
            voxelCount.put(v, 0);
        }

        for (Voxel v : filledVoxels) {
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dz = -1; dz <= 1; dz++) {
                        if (dx == 0 && dy == 0 && dz == 0) continue;
                        Voxel neighbor = new Voxel(v.x + dx, v.y + dy, v.z + dz);
                        if (filledVoxels.contains(neighbor)) {
                            voxelCount.put(neighbor, voxelCount.get(neighbor) + 1);
                        }
                    }
                }
            }
        }

        // Use voxelCount as needed
    }
}