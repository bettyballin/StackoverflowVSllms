/*
 * Decompiled with CFR 0.152.
 */
import java.util.Objects;

public class MetricsCalculator {
    public double xProjection(Point point, Point point2) {
        Objects.requireNonNull(point, "p1 is null");
        Objects.requireNonNull(point2, "p2 is null");
        return (point2.x - point.x) * 1.5;
    }

    public static void main(String[] stringArray) {
    }
}
