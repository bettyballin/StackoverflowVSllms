public class Person_2 {
    abstract class Person { /* ... */ }
    interface IUser {}
    class User extends Person implements IUser {}
    class Buyer extends User { /* specific business logic ...*/ }
    class Associate extends User { /* specific business logic... */ }
    // ... etc.
    public static void main(String[] args) {
    }
}