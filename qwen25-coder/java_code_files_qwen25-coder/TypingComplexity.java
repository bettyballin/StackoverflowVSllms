import java.util.HashMap;
import java.util.Map;

public class TypingComplexity {

    // Define the keyboard layout with positions (row, column)
    private static final Map<Character, int[]> KEY_POSITIONS = new HashMap<>();

    static {
        // Assuming QWERTY layout and finger assignment:
        // 0 = left pinky, 1 = left ring, ..., 7 = right index, 8 = right pinky
        setupKeyPositions();
    }

    private static void setupKeyPositions() {
        KEY_POSITIONS.put('q', new int[]{0, 0});
        KEY_POSITIONS.put('w', new int[]{0, 1});
        KEY_POSITIONS.put('e', new int[]{0, 2});
        KEY_POSITIONS.put('r', new int[]{0, 3});
        KEY_POSITIONS.put('t', new int[]{0, 4});
        KEY_POSITIONS.put('y', new int[]{0, 5});
        KEY_POSITIONS.put('u', new int[]{0, 6});
        KEY_POSITIONS.put('i', new int[]{0, 7});
        KEY_POSITIONS.put('o', new int[]{0, 8});
        KEY_POSITIONS.put('p', new int[]{0, 9});

        KEY_POSITIONS.put('a', new int[]{1, 0});
        KEY_POSITIONS.put('s', new int[]{1, 1});
        KEY_POSITIONS.put('d', new int[]{1, 2});
        KEY_POSITIONS.put('f', new int[]{1, 3});
        KEY_POSITIONS.put('g', new int[]{1, 4});
        KEY_POSITIONS.put('h', new int[]{1, 5});
        KEY_POSITIONS.put('j', new int[]{1, 6});
        KEY_POSITIONS.put('k', new int[]{1, 7});
        KEY_POSITIONS.put('l', new int[]{1, 8});
        KEY_POSITIONS.put(';', new int[]{1, 9});

        KEY_POSITIONS.put('z', new int[]{2, 0});
        KEY_POSITIONS.put('x', new int[]{2, 1});
        KEY_POSITIONS.put('c', new int[]{2, 2});
        KEY_POSITIONS.put('v', new int[]{2, 3});
        KEY_POSITIONS.put('b', new int[]{2, 4});
        KEY_POSITIONS.put('n', new int[]{2, 5});
        KEY_POSITIONS.put('m', new int[]{2, 6});
        KEY_POSITIONS.put(',', new int[]{2, 7});
        KEY_POSITIONS.put('.', new int[]{2, 8});
        KEY_POSITIONS.put('/', new int[]{2, 9});
    }

    public static double calculateComplexity(String word) {
        double complexity = 0.0;

        char[] chars = word.toCharArray();
        int lastFingerLocation = -1; // Track the previous finger position

        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                complexity += 0.5; // Penalty for capital letters (shift key)
            }

            int[] keyPosition = KEY_POSITIONS.get(Character.toLowerCase(c));
            if (keyPosition == null) continue;

            int fingerLocation = getFingerForPosition(keyPosition);

            // Calculate movement cost
            if (lastFingerLocation != -1) {
                complexity += Math.abs(fingerLocation - lastFingerLocation);
            }

            lastFingerLocation = fingerLocation;
        }

        return complexity;
    }

    private static int getFingerForPosition(int[] keyPosition) {
        // Simple column-based assignment for fingers
        int column = keyPosition[1];
        if (column == 0 || column == 9) return 0; // Pinkies
        if (column == 1 || column == 8) return 1; // Ring fingers
        if (column == 2 || column == 7) return 2; // Middle fingers
        if (column == 3 || column == 6) return 3; // Index fingers
        return 4; // Thumbs or others
    }

    public static void main(String[] args) {
        System.out.println("Complexity of 'suffer': " + calculateComplexity("suffer"));
        System.out.println("Complexity of 'people': " + calculateComplexity("people"));
    }
}