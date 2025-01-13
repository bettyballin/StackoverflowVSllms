/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class AlertGenerator {
    public static ArrayList<Alert> getAlert() {
        ArrayList<Alert> arrayList = new ArrayList<Alert>();
        arrayList.add(new Alert("alert1", "alert2", "alert3"));
        arrayList.add(new Alert("alert4", "alert5", "alert6"));
        arrayList.add(new Alert("alert7", "alert8", "alert9"));
        return arrayList;
    }

    public static void main(String[] stringArray) {
        ArrayList<Alert> arrayList = AlertGenerator.getAlert();
        for (Alert alert : arrayList) {
            System.out.println(alert);
        }
    }
}
