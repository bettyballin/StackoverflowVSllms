/*
 * Decompiled with CFR 0.152.
 */
public class GraphDiameterFinder {
    public double findDiameter() {
        int n = 0;
        double[] dArray = this.distancesFrom(n);
        int n2 = this.findFarthestNode(dArray);
        double[] dArray2 = this.distancesFrom(n2);
        int n3 = this.findFarthestNode(dArray2);
        return Math.max(dArray[n2], dArray2[n3]);
    }

    private int findFarthestNode(double[] dArray) {
        int n = 0;
        double d = 0.0;
        for (int i = 0; i < dArray.length; ++i) {
            if (!(dArray[i] > d)) continue;
            d = dArray[i];
            n = i;
        }
        return n;
    }

    private double[] distancesFrom(int n) {
        return new double[0];
    }

    public static void main(String[] stringArray) {
        GraphDiameterFinder graphDiameterFinder = new GraphDiameterFinder();
        double d = graphDiameterFinder.findDiameter();
        System.out.println("Graph diameter: " + d);
    }
}
