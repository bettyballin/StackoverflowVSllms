import java.lang.String;
import java.util.HashSet;

public class NonNullHashSet<E> extends HashSet<E>{
    @Override
    public boolean add(E e){
        if(e == null) throw new IllegalArgumentException("Null is not allowed in this set");
        return super.add(e);
    }

	public static void main(String[] args) {
	}
}