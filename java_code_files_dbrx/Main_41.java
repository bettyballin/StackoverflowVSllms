import java.lang.String;
class Parent {
    int x = 10; // This will be hidden by Child's 'x'.
}
class Child extends Parent {
    int x = 20; // Hiding Parent's 'x';
    public void printX() { // Overriding parent method.
        System.out.println(this.x);
    }
}
public class Main_41 {
   public static void main(String[] args) {
      Child c = new Child();  // Ref. type is Child and Object type is also Child here.
      Parent p = c;           // Now ref. type is Parent but object is still of 'Child'.
     System.out.println(c.x);   // Output will be - 20 (Child's x). Reason: Field accessed using reference type declared.
     System.out.println(p.x);   // Output will be - 10 (Parent's 'x'). Reason: The field of Parent is getting printed because ref. p doesn't know about Child's hidden field.
      c.printX();              // However, for methods printX () prints 20 (Child's x). This shows runtime polymorphism as actual object type dictates here even though the method was called using parent reference variable 'p'.
   }}