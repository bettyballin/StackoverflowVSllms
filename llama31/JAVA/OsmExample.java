import java.lang.String;
import java.lang.Set;
import com.github.osmnx.OsmNx;
import com.github.osmnx.model.BoundingBox;
import com.github.osmnx.model.MapData;

public class OsmExample {
    public static void main(String[] args) {
        // Set bounding box coordinates (lat, lon)
        BoundingBox bbox = new BoundingBox(37.7749, -122.4194, 37.7859, -122.4364);

        // Load map data
        MapData mapData = OsmNx.load(bbox);

        // Print map data
        System.out.println(mapData.getNodes().size() + " nodes");
        System.out.println(mapData.getWays().size() + " ways");
        System.out.println(mapData.getRelations().size() + " relations");
    }
}