import java.util.List;
import java.util.ArrayList;

public class StringChunker {
    private List<String> breakStringInChunks(String text, int chunkSize) {
        List<String> chunks = new ArrayList<>();
        int beginIndex = 0;

        while (beginIndex < text.length()) {
            int endIndex = Math.min(beginIndex + chunkSize, text.length());
            chunks.add(text.substring(beginIndex, endIndex));
            beginIndex = endIndex;
        }

        return chunks;
    }

    public static void main(String[] args) {
        StringChunker chunker = new StringChunker();
        String text = "Hello, World!";
        int chunkSize = 5;
        List<String> chunks = chunker.breakStringInChunks(text, chunkSize);
        System.out.println(chunks);
    }
}