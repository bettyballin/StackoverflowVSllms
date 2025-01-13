import java.lang.String;
import java.lang.reflect.Field;

public class Outer {
  public static void foo(Inner inner) throws Exception {
    Field field = inner.getClass().getDeclaredField("this$0");
    field.setAccessible(true);
    Outer outer = (Outer) field.get(inner);
    System.out.println("The outer class is: " + outer);
  }
  public class Inner {}

	public static void main(String[] args) throws Exception {
		Outer outer = new Outer();
		Inner inner = outer.new Inner();
		foo(inner);
	}
}