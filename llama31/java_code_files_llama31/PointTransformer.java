/*
 * Decompiled with CFR 0.152.
 */
public class PointTransformer
implements Transform<Point> {
    @Override
    public Point read(String string) throws Exception {
        String[] stringArray = string.split(",");
        return new Point(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]));
    }

    @Override
    public String write(Point point) throws Exception {
        return (int)point.x + "," + point.y;
    }

    public static void main(String[] stringArray) {
    }
}
