import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.RoadsApi;
import com.google.maps.model.LatLng;
import com.google.maps.model.SnapToRoadsResponse;
import com.google.maps.model.SnapToRoadsResult;

public class Main_703 {
    public static void main(String[] args) {
        // Set up your API key and context
        String apiKey = "YOUR_API_KEY";
        GeoApiContext context = new GeoApiContext.Builder()
            .apiKey(apiKey)
            .build();

        // Set up the coordinates of the street
        LatLng streetCoordinates = new LatLng(37.7749, -122.4194); // Replace with your coordinates

        // Set up the snap to roads request
        PendingResult<SnapToRoadsResponse> pendingResult = RoadsApi.snapToRoads(context, false, streetCoordinates);

        // Execute the request
        SnapToRoadsResponse response = pendingResult.await();

        // Get the nearest intersection
        LatLng nearestIntersection = response.snappedPoints.get(0).nearestIntersection.location;

        System.out.println("Nearest intersection: " + nearestIntersection);
    }
}