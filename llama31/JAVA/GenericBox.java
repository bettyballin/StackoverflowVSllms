import java.lang.String;
public class GenericBox<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

	public static void main(String[] args) {
	}
}