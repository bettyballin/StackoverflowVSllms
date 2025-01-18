public class Main {
    public static void main(String[] args) {
        String inputName = "lastname, firstname";
        String[] nameParts = inputName.split(",");    // split input string into two parts separated by comma
        String outputName = String.format("%s %s", nameParts[1].trim(), nameParts[0].trim());  // reverse the order and join using space
        System.out.println(outputName);   // prints "firstname lastname"
    }
}