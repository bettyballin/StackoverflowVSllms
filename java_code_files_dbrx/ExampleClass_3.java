import java.lang.String;
// This is an example of using FxCop in c#
public class ExampleClass_3
{
   // Violates rule CA1801: ReviewUnusedParameters because parameter 'y' is not used.
    public void ProcessItem (int x, int y) { }

	public static void main(String[] args) {
	}
}