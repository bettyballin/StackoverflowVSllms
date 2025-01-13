/*
 * Decompiled with CFR 0.152.
 */
public class AngleConverter {
    public double deg2rad(double d) {
        return d * Math.PI / 180.0;
    }

    public double rad2deg(double d) {
        return d * 180.0 / Math.PI;
    }

    public static void main(String[] stringArray) {
        AngleConverter angleConverter = new AngleConverter();
        double d = 45.0;
        double d2 = angleConverter.deg2rad(d);
        System.out.println(d + " degrees is equal to " + d2 + " radians");
        d2 = 1.5707963267948966;
        d = angleConverter.rad2deg(d2);
        System.out.println(d2 + " radians is equal to " + d + " degrees");
    }
}
