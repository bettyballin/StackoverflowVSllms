// To compile this code with javac, ensure that the OWASP Java Encoder library is included in your classpath.
// You can download the library from https://owasp.org/www-project-java-encoder/
// Compile with:
// javac -cp .;path/to/owasp-java-encoder-1.2.3.jar EncodeExample.java
// (Replace '1.2.3' with the actual version number of the library you downloaded)

import org.owasp.encoder.Encode;

public class EncodeExample {
    public static void main(String[] args) {
        String userInput = ""; // Initialize userInput as needed
        String safeInput = Encode.forHtml(userInput);
        System.out.println("Encoded input: " + safeInput);
    }
}