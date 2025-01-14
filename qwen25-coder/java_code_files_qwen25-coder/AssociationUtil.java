import java.util.ArrayList;
import java.util.List;

public class AssociationUtil {

    public static void linkAtoB(A a, B b) {
        if (a.getB() != null && a.getB().getAs().contains(a)) {
            a.getB().getAs().remove(a);
        }
        a.setB(b);
        if (!b.getAs().contains(a)) {
            b.getAs().add(a);
        }
    }

    public static void unlinkAfromB(A a) {
        if (a.getB() != null && a.getB().getAs().contains(a)) {
            a.getB().getAs().remove(a);
        }
        a.setB(null);
    }
}

class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}

class B {
    private final List<A> as = new ArrayList<>();

    public List<A> getAs() {
        return as;
    }

	public static void main(String[] args) {
	}
}