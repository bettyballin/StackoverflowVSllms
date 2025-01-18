import java.lang.String;
public class Test_15 {
    static class Test {
        public void doSomething() {
            // This block is locked from other threads trying to enter this method in same instance. But not
            // between multiple instances or different methods.

            synchronized(this) {
                // critical section here
            }
        }

        public static void doOtherThing() {
            // In case of a class object, it is the Class Object that gets locked which means only one thread at a time can make call to any synchronized instance methods.

            synchronized(Test.class) {
                // critical section here. Any other method trying to get lock on Test.class (not just static methods), has to wait for this block to finish execution.
            }
        }
    }
    public static void main(String[] args) {
    }
}