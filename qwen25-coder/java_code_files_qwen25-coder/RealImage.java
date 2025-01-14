import java.lang.String;
public class RealImage {
   // Example: Controlling remote file access through a proxy
   interface Image {
       void display();
   }
   class RealImageImpl implements Image{}
   class ProxyImage implements Image{ 
       private RealImageImpl realImage;
   }

	public static void main(String[] args) {
	}
}