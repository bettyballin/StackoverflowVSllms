import java.lang.String;
// Example of Type Erasure influence in Java generics
public class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

	public static void main(String[] args) {
	}
}