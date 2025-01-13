import java.util.ArrayList;
import java.util.List;

public class PostScriptTableDetector {
    private List<float[]> movetoCoords = new ArrayList<>();
    private List<float[]> linetoCoords = new ArrayList<>();

    public void parsePostScript(String postScriptCode) {
        // Tokenize the PostScript code
        String[] tokens = postScriptCode.split("\\s+");

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("moveto")) {
                // Extract coordinates from the previous tokens
                float x = Float.parseFloat(tokens[i - 2]);
                float y = Float.parseFloat(tokens[i - 1]);
                movetoCoords.add(new float[] { x, y });
            } else if (tokens[i].equals("lineto")) {
                // Extract coordinates from the previous tokens
                float x = Float.parseFloat(tokens[i - 2]);
                float y = Float.parseFloat(tokens[i - 1]);
                linetoCoords.add(new float[] { x, y });
            }
        }
    }

    public boolean isInsideTable(float x, float y) {
        // Simple check: if the point is inside a "box" formed by two moveto and two lineto coordinates
        for (int i = 0; i < movetoCoords.size() - 1; i++) {
            float[] p1 = movetoCoords.get(i);
            float[] p2 = movetoCoords.get(i + 1);
            float[] p3 = linetoCoords.get(i);
            float[] p4 = linetoCoords.get(i + 1);

            if (x >= p1[0] && x <= p2[0] && y >= p1[1] && y <= p3[1]) {
                return true; // point is inside the "box"
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PostScriptTableDetector detector = new PostScriptTableDetector();
        // Example usage
        String postScriptCode = "10 20 moveto 30 40 lineto 50 60 moveto 70 80 lineto";
        detector.parsePostScript(postScriptCode);
        System.out.println(detector.isInsideTable(25, 35)); // prints: true
        System.out.println(detector.isInsideTable(75, 85)); // prints: false
    }
}