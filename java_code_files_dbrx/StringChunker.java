import java.util.ArrayList;
import java.util.List;

public class StringChunker {
    private List<String> breakStringInChunks(String text, int chunkSize) {
        List<String> chunks = new ArrayList<>();
        int numberOfChunks = text.length() / chunkSize;   // fixed typo in length() function call
        if ((numberOfChunks * chunkSize) < text.length())   // fixed typo in length() function call
            numberOfChunks++;
        for (int i = 0, beginIndex = 0; i <= numberOfChunks; i++) {   // init and use begin index within the loop
            int endIndex = Math.min(beginIndex + chunkSize, text.length());   // ensure end is never out of bounds
            String temporary = text.substring(beginIndex, endIndex);    // this line will always return a valid substring now.
            chunks.add(temporary);
            beginIndex = endIndex;  // moved here so first index always starts from the last used position in next iteration
        }
         return chunks;
    }
    	public static void main(String[] args) {
    	}
}