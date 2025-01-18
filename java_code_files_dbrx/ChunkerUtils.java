import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class ChunkerUtils {
    private static List<byte[]> getChunkedData(byte[] data, int sizeOfEachChunk) {
        List<byte[]> chunks = new ArrayList<>();
        byte[] currentChunk;
        int numberOfChunks = (int) Math.ceil((double) data.length / sizeOfEachChunk);

        for (int i = 0; i < numberOfChunks; ++i) {
            if (i == numberOfChunks - 1) { // last one
                currentChunk = Arrays.copyOfRange(data, sizeOfEachChunk * i, data.length);
            } else {
                currentChunk = Arrays.copyOfRange(data, sizeOfEachChunk * i, sizeOfEachChunk * (i + 1));
            }
            chunks.add(currentChunk);
        }
        return chunks;
    }

    public static void main(String[] args) {
    }
}