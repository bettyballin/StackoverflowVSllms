import java.util.List;
import java.util.ArrayList;

public class B_3 {
    private List<A> as = new AutoList<A>() {
        @Override public boolean add(A a) {
            if (super.add(a)) {
                a.setB(B_3.this);
                return true;
            } else {
                return false;
            }
        }
    };

    public static void main(String[] args) {
    }
}

class A {
    public void setB(B_3 b) {
        // Implementation here
    }
}

class AutoList<E> extends ArrayList<E> {
    // No additional implementation needed
}