import java.lang.String;
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

	public static void main(String[] args) {
	}
}