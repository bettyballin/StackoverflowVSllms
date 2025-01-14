import java.lang.String;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.WKTWriter;

public class PolygonDifferenceExample {
    public static void main(String[] args) throws Exception {
        // Create GeometryFactory which is used to create geometric objects
        GeometryFactory geometryFactory = new GeometryFactory();

        // Define the first rectangle (black cookie)
        Coordinate[] coordinates1 = new Coordinate[]{
            new Coordinate(0, 0),
            new Coordinate(10, 0),
            new Coordinate(10, 5),
            new Coordinate(0, 5),
            new Coordinate(0, 0) // close the polygon
        };
        Polygon rectangle1 = geometryFactory.createPolygon(coordinates1);

        // Define the second rectangle (red cookie cutter)
        Coordinate[] coordinates2 = new Coordinate[]{
            new Coordinate(5, -1), // Start from below and slightly left to ensure correct operation
            new Coordinate(15, -1),
            new Coordinate(15, 3),
            new Coordinate(5, 3),
            new Coordinate(5, -1) // close the polygon
        };
        Polygon rectangle2 = geometryFactory.createPolygon(coordinates2);

        // Perform the difference operation
        Geometry resultGeometry = rectangle1.difference(rectangle2);

        // Output the resulting polygon in Well-Known Text (WKT) format
        WKTWriter writer = new WKTWriter();
        System.out.println("Resulting Geometry: " + writer.write(resultGeometry));
    }
}