/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class Colors {
    private List<String> colors = new ArrayList<String>();

    public void addColor(String string) {
        this.colors.add(string);
    }

    public List<String> getColors() {
        return this.colors;
    }

    public static void main(String[] stringArray) {
        Colors colors = new Colors();
        colors.addColor("Red");
        colors.addColor("Green");
        colors.addColor("Blue");
        System.out.println(colors.getColors());
    }
}
