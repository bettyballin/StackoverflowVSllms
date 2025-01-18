// To compile this code, you need to include the Apache Commons Lang library in your classpath.
// Download the library from: https://commons.apache.org/proper/commons-lang/download_lang.cgi
// Assuming you have the `commons-lang3-3.x.jar` file, compile and run the code as follows:

// On Windows:
// Compilation:
// javac -cp .;commons-lang3-3.x.jar Main_18.java
// Execution:
// java -cp .;commons-lang3-3.x.jar Main_18

// On macOS/Linux:
// Compilation:
// javac -cp .:commons-lang3-3.x.jar Main_18.java
// Execution:
// java -cp .:commons-lang3-3.x.jar Main_18

import org.apache.commons.lang3.StringEscapeUtils;

public class Main_18 {
    public static void main(String[] args) {
        String escapedStr = StringEscapeUtils.escapeHtml("…");
        System.out.println(escapedStr); // Prints "&#8230;" which is the expected result.
    }
}