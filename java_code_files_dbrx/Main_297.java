public class Main {
    public static void main(String[] args) {
        int age = 30;  // Define the age variable
        StringBuilder builder = new StringBuilder();
        builder.append("John");
        builder.append(" is ");
        builder.append(age);
        builder.append(" years old.");
        String output3 = builder.toString(); //"John is 30 years old."

        System.out.println(output3);  // Optional: Print the output
    }
}