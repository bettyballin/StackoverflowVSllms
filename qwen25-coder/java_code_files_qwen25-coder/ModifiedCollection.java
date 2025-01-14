import java.lang.String;
import java.util.Collection;
import java.util.ArrayList;

public class ModifiedCollection<E> {
    private Collection<E> wrapperSet = new ArrayList<E>();

    public boolean addAll(Collection<? extends E> c) {
        if (null == c) {
            throw new NullPointerException("c cannot be null");
        }

        for (E e : c) {
            if (e == null) {
                throw new NullPointerException("c cannot contain null elements");
            }
        }

        return this.wrapperSet.addAll(c);
    }
    public static void main(String[] args) {
    }
}