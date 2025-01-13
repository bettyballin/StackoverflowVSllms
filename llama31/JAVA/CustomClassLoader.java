import java.lang.String;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader extends URLClassLoader {
    public CustomClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    public void close() {
        try {
            super.close();
        } catch (Exception e) {
            // Handle exception
        }
    }

	public static void main(String[] args) {
	}
}