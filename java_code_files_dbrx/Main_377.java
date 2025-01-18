import java.lang.String;
import java.util.regex.*;
public class Main_377{
    public static void main(String[] args) {
        System.out.println(checkString("test123.txt")); //should return true
        System.out.println(checkString("test!@#$%^&*()()")) ;  //should return false
    }
     static boolean checkString(String str){
         Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\.]*$");
           Matcher matcher = pattern.matcher(str);
           return matcher.matches();
      }
}