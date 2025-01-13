import java.lang.String;
public class Test_10 {
    private static final Object someObject = new Object();

    public synchronized static void doSomething() {
        System.out.println(someObject.toString());
    }

	public static void main(String[] args) {
	}
}