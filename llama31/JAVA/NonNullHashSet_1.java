import java.util.Collection;
import java.util.HashSet;

public class NonNullHashSet_1_1<E> extends HashSet<E> {
    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("Cannot add null to this set");
        }
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            if (e == null) {
                throw new NullPointerException("Cannot add null to this set");
            }
        }
        return super.addAll(c);
    }

	public static void main(String[] args) {
	}
}