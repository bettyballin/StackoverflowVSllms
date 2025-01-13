public class Outer_1_1 {
  public static void foo(Outer_1.Inner inner) {
    System.out.println("The outer class is: " + inner.getOuter());
  }
  public class Inner {
    public final Outer_1 getOuter() { return Outer_1.this; }
  }

	public static void main(String[] args) {
		Outer_1 outer = new Outer_1();
		Outer_1.Inner inner = outer.new Inner();
	(foo(inner);
	}
}