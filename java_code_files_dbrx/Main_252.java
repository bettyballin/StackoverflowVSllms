public class Main {

    public static void main(String[] args) {
        // somewhere inside your source code you instantiate class A and B:
        A aRef = new A();  // create an instance of Class A
        B bRef = new B();  // create an instance of Class B
        bRef.start(aRef);  // call start() with the reference to 'aRef'
    }

    static class A {
        public void methodA() { /* some code here... */ }
    }

    static class B extends Thread {
        private C cInstance;
        private A aRef;

        public void start(A aRef) {
            this.aRef = aRef;
            super.start();
        }

        @Override
        public void run(){
            super.run(); // this will just execute the run() method of your superclass(Thread) which does nothing!
            cInstance = new C(aRef);
            //...other code here...
        }
    }

    static class C {
        private A aInstance;
        public C(A a) { this.aInstance = a; }
        public void methodC(){
            if(aInstance != null){
                aInstance.methodA();
            }
        }
    }
}