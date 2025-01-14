import java.lang.String;
public class Example_1 {
    public void printNumbers(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(i);
        }
    }

    // Potential improvement: Use StringBuilder for concatenation in loops
    public String concatenateStrings(String[] strings) {
        String result = "";
        for (String str : strings) {
            result += str; // Inefficient string concatenation in a loop
        }
        return result;
    }

	public static void main(String[] args) {
	}
}