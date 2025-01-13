import java.lang.String;
import java.lang.Integer;
import java.io.*;
import java.util.*;

public class ExternalSort {
    public static void sort(String inputFile, String outputFile) throws IOException {
        // Read input file in chunks of 100,000 integers ( approx. 400KB)
        int chunkSize = 100000;
        int numChunks = (int) Math.ceil(1000000 / (double) chunkSize);

        // Sort each chunk in memory and write to disk
        for (int i = 0; i < numChunks; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, 1000000);

            // Read chunk from input file
            DataInputStream dis = new DataInputStream(new FileInputStream(inputFile));
            dis.skipBytes(start * 4); // Skip to the start of the chunk
            int[] chunk = new int[end - start];
            for (int j = 0; j < chunk.length; j++) {
                chunk[j] = dis.readInt();
            }
            dis.close();

            // Sort chunk in memory
            Arrays.sort(chunk);

            // Write sorted chunk to disk
            String chunkFile = "chunk" + i + ".dat";
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(chunkFile));
            for (int j = 0; j < chunk.length; j++) {
                dos.writeInt(chunk[j]);
            }
            dos.close();
        }

        // Merge sorted chunks
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(outputFile));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < numChunks; i++) {
            String chunkFile = "chunk" + i + ".dat";
            DataInputStream dis = new DataInputStream(new FileInputStream(chunkFile));
            queue.add(dis.readInt());
            dis.close();
        }

        while (!queue.isEmpty()) {
            int val = queue.poll();
            dos.writeInt(val);
            for (int i = 0; i < numChunks; i++) {
                String chunkFile = "chunk" + i + ".dat";
                DataInputStream dis = new DataInputStream(new FileInputStream(chunkFile));
                int nextVal = dis.readInt();
                if (nextVal < val) {
                    queue.add(nextVal);
                }
                dis.close();
            }
        }
        dos.close();
    }

    public static void main(String[] args) throws IOException {
        String inputFile = "input.dat";
        String outputFile = "output.dat";
        sort(inputFile, outputFile);
    }
}