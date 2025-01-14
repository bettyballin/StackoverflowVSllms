import java.lang.String;
public class YourActionClass_1 {
       private String param1; // Corresponding to 'param1' sent via AJAX

       // Getter and Setter
       public void setParam1(String param1) {
           this.param1 = param1;
       }

       public static final String SUCCESS = "success";

       public String execute(){
           System.out.println("Parameter received: " + param1);
           // Your logic here
           
           return SUCCESS; // or another valid result code depending on your struts.xml config
       }

       public static void main(String[] args) {
       }
}