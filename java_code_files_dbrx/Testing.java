import java.lang.String;
import java.util.regex.*;
public class Testing {
  public static void main(String[] args){
    String pattern = "(?<=content=['\"])[^\"']*(?=['\"])" ;
    Matcher m = Pattern.compile(pattern).matcher("<meta content='blogger' name='generator'/>");
    if (m.find()) {
       System.out.println("Generator: " + m.group());
    }
  }
}