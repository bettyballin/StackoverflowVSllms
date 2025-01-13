/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class ContinuousScalarField {
    private List<Measurement> measurements = new ArrayList<Measurement>();
    private boolean isBuilt = false;

    public void add(Measurement measurement) {
        if (this.isBuilt) {
            throw new IllegalStateException("Cannot add measurements after finalization");
        }
        this.measurements.add(measurement);
    }

    public void build() {
        if (this.isBuilt) {
            return;
        }
        this.isBuilt = true;
    }

    public Measurement interpolateAt(Point3d point3d) {
        if (!this.isBuilt) {
            throw new IllegalStateException("Must call build() before querying");
        }
        return null;
    }

    public static void main(String[] stringArray) {
        ContinuousScalarField continuousScalarField = new ContinuousScalarField();
    }
}
