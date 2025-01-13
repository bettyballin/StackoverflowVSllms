import java.lang.String;
public class Resource_1 {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Resource finalized");
        super.finalize();
    }

	public static void main(String[] args) {
	}
}