public class SillyClassName {
    private Object moo;

    public void method1(){
        synchronized(moo) { // First synchronization block
            // ...
            method2();
            // ...
        }
    }

    public void method2(){
        synchronized(moo) { // Second synchronization block
            doStuff();
        }
    }

    private void doStuff() {
        // Method implementation
    }
}