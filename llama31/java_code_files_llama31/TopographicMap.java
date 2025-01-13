/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class TopographicMap {
    private double[][] elevationData;
    private double[][] gradientData;
    private List<ContourLine> contourLines;

    public TopographicMap(double[][] dArray) {
        this.elevationData = dArray;
        this.gradientData = this.calculateGradient(dArray);
        this.contourLines = this.findContourLines(this.gradientData);
    }

    private double[][] calculateGradient(double[][] dArray) {
        double[][] dArray2 = new double[dArray.length][dArray[0].length];
        return dArray2;
    }

    private List<ContourLine> findContourLines(double[][] dArray) {
        ArrayList<ContourLine> arrayList = new ArrayList<ContourLine>();
        return arrayList;
    }

    public void renderContourLines(Graphics graphics) {
        for (ContourLine contourLine : this.contourLines) {
            contourLine.render(graphics);
        }
    }

    public static void main(String[] stringArray) {
        double[][] dArrayArray = new double[][]{{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, 10.0}, {11.0, 12.0, 13.0, 14.0, 15.0}, {16.0, 17.0, 18.0, 19.0, 20.0}, {21.0, 22.0, 23.0, 24.0, 25.0}};
        TopographicMap topographicMap = new TopographicMap(dArrayArray);
    }
}
