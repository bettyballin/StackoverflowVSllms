public class Main {
    public static void main(String[] args) {
        String[] array = {"Hello", "World", "Java"};
        
        // Using String.join method (available from Java 8)
        String newString = String.join(" ", array);

        // Or without using the join method which is available from Java 8
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            // Append the string
            str.append(array[i]);
            if (i != array.length - 1) {
                // Append spaces in between, except after the last item of the array
                str.append(" ");
            }
            // This can also be done inside append but it will add an extra trailing space
        }
        String finalString = str.toString();

        System.out.println(newString);
        System.out.println(finalString);
    }
}