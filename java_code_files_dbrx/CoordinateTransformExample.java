import org.geotools.referencing.CRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

public class CoordinateTransformExample {
    public static void main(String[] args) {
        try {
            CoordinateReferenceSystem source = CRS.decode("EPSG:26915"); // UTM Zone 15N
            CoordinateReferenceSystem target = CRS.decode("EPSG:4326"); // WGS84
            MathTransform transform = CRS.findMathTransform(source, target);

            double xValueAsDouble = Double.parseDouble(args[0]);
            double yValueAsDouble = Double.parseDouble(args[1]);

            double[] sourcePoint = new double[]{xValueAsDouble, yValueAsDouble};
            double[] targetPoint = new double[2];

            transform.transform(sourcePoint, 0, targetPoint, 0, 1);

            double latitude = targetPoint[1]; // Latitude value in degrees as double
            double longitude = targetPoint[0]; // Longitude value in degrees as double

            System.out.println("Latitude: " + latitude);
            System.out.println("Longitude: " + longitude);
        } catch (FactoryException | TransformException e) {
            // Handle exceptions accordingly
            e.printStackTrace();
        }
    }
}