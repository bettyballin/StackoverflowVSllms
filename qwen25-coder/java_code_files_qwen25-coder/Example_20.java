import java.lang.String;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;

@Root(name = "example")
public class Example_20 {
    @Element(name = "location")
    @Convert(PointConverter.class)
    private Point location;

    public Example_20() {} // Default constructor needed for reflection

    public Example_20(Point location) {
        this.location = location;
    }

    // Getters and setters
    public Point getLocation() { return location; }
    public void setLocation(Point location) { this.location = location; }

    public static void main(String[] args) {
    }
}