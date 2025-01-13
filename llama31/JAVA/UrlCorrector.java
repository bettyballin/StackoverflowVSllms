import java.lang.String;
public class UrlCorrector {
public static void main(String[] args) {
        String s = "ihttp://www.ourdomain.com/images/f2f3f4.gif";
        String result = s.replace("ihttp://", "http://");
        System.out.println(result);
    }
}