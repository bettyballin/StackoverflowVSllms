/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class PostScriptTableDetector {
    private List<float[]> movetoCoords = new ArrayList<float[]>();
    private List<float[]> linetoCoords = new ArrayList<float[]>();

    public void parsePostScript(String string) {
        String[] stringArray = string.split("\\s+");
        for (int i = 0; i < stringArray.length; ++i) {
            float f;
            float f2;
            if (stringArray[i].equals("moveto")) {
                f2 = Float.parseFloat(stringArray[i - 2]);
                f = Float.parseFloat(stringArray[i - 1]);
                this.movetoCoords.add(new float[]{f2, f});
                continue;
            }
            if (!stringArray[i].equals("lineto")) continue;
            f2 = Float.parseFloat(stringArray[i - 2]);
            f = Float.parseFloat(stringArray[i - 1]);
            this.linetoCoords.add(new float[]{f2, f});
        }
    }

    public boolean isInsideTable(float f, float f2) {
        for (int i = 0; i < this.movetoCoords.size() - 1; ++i) {
            float[] fArray = this.movetoCoords.get(i);
            float[] fArray2 = this.movetoCoords.get(i + 1);
            float[] fArray3 = this.linetoCoords.get(i);
            float[] fArray4 = this.linetoCoords.get(i + 1);
            if (!(f >= fArray[0]) || !(f <= fArray2[0]) || !(f2 >= fArray[1]) || !(f2 <= fArray3[1])) continue;
            return true;
        }
        return false;
    }

    public static void main(String[] stringArray) {
        PostScriptTableDetector postScriptTableDetector = new PostScriptTableDetector();
        String string = "10 20 moveto 30 40 lineto 50 60 moveto 70 80 lineto";
        postScriptTableDetector.parsePostScript(string);
        System.out.println(postScriptTableDetector.isInsideTable(25.0f, 35.0f));
        System.out.println(postScriptTableDetector.isInsideTable(75.0f, 85.0f));
    }
}
