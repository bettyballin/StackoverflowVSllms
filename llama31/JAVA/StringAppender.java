import java.lang.String;
public class StringAppender {
public static void main(String[] args) throws Exception {
StringBuffer sb = new StringBuffer();
int i = 1;
sb.append("a").append(i);
String s = sb.toString();
System.out.println(s);
}
}