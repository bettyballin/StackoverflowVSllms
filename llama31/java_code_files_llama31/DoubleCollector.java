/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoubleCollector {
    Map<String, Double> themap = new HashMap<String, Double>();
    Collection<Double> coll = this.themap.values();
    List<Double> list = new ArrayList<Double>(this.coll);

    public static void main(String[] stringArray) {
        new DoubleCollector();
    }
}
