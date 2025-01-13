public class Main_524 {
    public static void main(String[] args) {
        class Parent {
            int x = 10;
            void foo() { System.out.println("Parent.foo"); }
        }

        class Child extends Parent {
            int x = 20;
            @Override void foo() { System.out.println("Child.foo"); }
        }

        Child child = new Child();
        Parent parent = (Parent) child;

        System.out.println(parent.x); // prints 10 (Parent's field)
        parent.foo(); // prints "Child.foo" (Child's overridden method)
    }
}