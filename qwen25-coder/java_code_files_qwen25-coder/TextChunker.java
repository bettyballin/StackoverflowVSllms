import java.util.List;
import java.util.ArrayList;

public class TextChunker {
    private List<String> breakStringInChunks(String text, int chunkSize) {
        List<String> chunks = new ArrayList<>();
        StringBuilder temporary = new StringBuilder();

        for (int i = 0; i < text.length(); i += chunkSize) {
            int end = Math.min(i + chunkSize, text.length());
            chunks.add(text.substring(i, end));
        }

        return chunks;
    }

    public static void main(String[] args) {
    }
}