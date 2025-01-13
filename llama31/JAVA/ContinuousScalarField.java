import java.util.ArrayList;
import java.util.List;

class Measurement {
    // Add properties and methods as needed
}

class Point3d {
    // Add properties and methods as needed
}

public class ContinuousScalarField {
    private List<Measurement> measurements;
    private boolean isBuilt = false;

    public ContinuousScalarField() {
        measurements = new ArrayList<>();
    }

    public void add(Measurement measurement) {
        if (isBuilt) {
            throw new IllegalStateException("Cannot add measurements after finalization");
        }
        measurements.add(measurement);
    }

    public void build() {
        if (isBuilt) {
            return;
        }
        // Perform heavy-duty analysis here
        isBuilt = true;
    }

    public Measurement interpolateAt(Point3d point) {
        if (!isBuilt) {
            throw new IllegalStateException("Must call build() before querying");
        }
        // Perform interpolation here
        return null; // Replace with actual implementation
    }

    public static void main(String[] args) {
        ContinuousScalarField field = new ContinuousScalarField();
        // Example usage:
        // field.add(new Measurement());
        // field.build();
        // field.interpolateAt(new Point3d());
    }
}