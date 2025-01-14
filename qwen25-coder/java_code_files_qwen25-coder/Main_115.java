import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date myDate = new Date();
        System.out.println(myDate);  //Tue Sep 16 13:02:44 EDT 2008
        long timestamp = myDate.getTime();
        System.out.println(timestamp); //1221584564703
    }
}