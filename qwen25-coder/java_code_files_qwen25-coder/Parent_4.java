public class Parent_4 {
    static class Parent {
        int x = 10;
        void show() { System.out.println("Parent Show"); }
    }

    static class Child extends Parent {
        int x = 20; // Hides the 'x' of parent
        @Override
        void show() { System.out.println("Child Show"); }
    }

    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.x); // Outputs: 10 (accesses field via reference type)
        p.show(); // Outputs: Child Show (method via instance type)
    }
}