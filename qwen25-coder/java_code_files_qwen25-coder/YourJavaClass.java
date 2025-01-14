public class YourJavaClass {
    public String processParameter(String param) {
        // Process the parameter as needed
        return "Processed: " + param;
    }

    public static void main(String[] args) {
        YourJavaClass instance = new YourJavaClass();
        String result = instance.processParameter("Your input parameter");
        System.out.println(result);
    }
}