import javax.xml.bind.annotation.Element;
import javax.xml.bind.annotation.XmlRootElement;

public class GeometryEntity {
    @Element
    private Point point;

    public static void main(String[] args) {
    }
}

// Assuming PointTransformer is a custom transformer class
class PointTransformer {
    // transformer implementation
}

// Assuming Point is a custom class
class Point {
    // point implementation
}