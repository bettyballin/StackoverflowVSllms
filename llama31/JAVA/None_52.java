import java.lang.String;

public class None_52_52 {
    // In the first JSP page
    public static void main(String[] args) {
        String parameter = "someValue";
        String url = "secondPage.jsp?param=" + parameter;
        System.out.println(url); // print the URL instead of redirecting
    }
}