import java.util.Collection;
import java.util.ArrayList;

public class ContinuousScalarField {
    private boolean isPrepared = false;
    private Collection<Measurement> measurements = new ArrayList<>();
    // ... other fields for internal data structures

    public void add(Measurement measurement) {
        if (isPrepared) {
            throw new IllegalStateException("Cannot add more data after field preparation.");
        }
        measurements.add(measurement);
    }

    public void prepareForQuery() throws Exception {
        if (!isPrepared) {
            performHeavyAnalysis();
            isPrepared = true;
        }
    }

    private void performHeavyAnalysis() throws Exception {
        // ... implementation of heavy analysis
    }

    public Measurement interpolateAt(Point3d point) throws Exception {
        if (!isPrepared) {
            prepareForQuery();
        }
        return doInterpolation(point);
    }

    private Measurement doInterpolation(Point3d point) {
        // ... interpolation logic
        return new Measurement();
    }

    public static void main(String[] args) {
    }
}

class Measurement {
    // ... implementation details
}

class Point3d {
    // ... implementation details
}