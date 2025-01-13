/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

class ContourLine {
    private List<Point> points;

    public ContourLine(List<Point> list) {
        this.points = list;
    }

    public void render(Graphics graphics) {
        for (int i = 0; i < this.points.size() - 1; ++i) {
            Point point = this.points.get(i);
            Point point2 = this.points.get(i + 1);
            graphics.drawLine(point.x, point.y, point2.x, point2.y);
        }
    }
}
