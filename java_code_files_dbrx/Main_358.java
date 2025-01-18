import java.lang.String;
import org.springframework.web.util.UriUtils;
//... other imports
public class Main_358 {
    public static void main(String[] args){
        String uri = UriUtils.encode("http://google.com/resource?key=value1 & value2", "UTF-8");
        System.out.println(uri); //prints: http%3A%2F%2Fgoogle.com%2Fresource%3Fkey%3Dvalue1+%26amp%3B+value2
    }
}