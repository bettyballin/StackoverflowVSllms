public class C {
    class CInner {
        private final A a; // direct reference to avoid getter calls and violation of LoD
        private B b;

        public CInner(B b, A a) {
            this.b = b;
            this.a = a;
        }

        public A getA() {
            return this.a;
        }

        public B getB() {
            return this.b;
        }

        public void methodNeedingA() {
            /* can call methods directly on both B and A */
            this.getB().callMethodInB();
            this.getA().runMethodX();
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        CInner cInner = c.new CInner(b, a);
        cInner.methodNeedingA();
    }
}

class A {
    public void runMethodX() {
        System.out.println("Method X in class A");
    }
}

class B {
    public void callMethodInB() {
        System.out.println("Method in class B called");
    }
}