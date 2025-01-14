public class GuidLengthCalculator {
    public static void main(String[] args) {
        String guid = "{xxxxxxxx-xxxx-Mxxx-Nxxx-xxxxxxxxxxxx}";
        int length = guid.length();
        System.out.println("The length of the GUID including curly brackets is: " + length);
    }
}