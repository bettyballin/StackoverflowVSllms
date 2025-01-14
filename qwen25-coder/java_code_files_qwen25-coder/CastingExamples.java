import java.lang.String;
import java.lang.Integer;
public class CastingExamples {
Object obj = "Hello";
String str = (String) obj; // Safe because obj actually references a String object

// This will throw ClassCastException
Integer num = (Integer) obj;
	public static void main(String[] args) {
	}
}