import java.lang.String;
public class MyClass_25 {
    public int publicField; // accessible from anywhere
    protected int protectedField; // accessible within the same class and subclasses
    int packagePrivateField; // accessible within the same package
    private int privateField; // accessible only within the same class

    public void publicMethod() {} // accessible from anywhere
    protected void protectedMethod() {} // accessible within the same class and subclasses
    void packagePrivateMethod() {} // accessible within the same package
    private void privateMethod() {} // accessible only within the same class

	public static void main(String[] args) {
	}
}