import java.nio.ByteBuffer;
    
public class Main {
    public static void main(String[] args) {
        byte[] array = {1, 2, 3, 4, 5};
        ByteBuffer buffer = ByteBuffer.wrap(array);

        // Move elements from position 2 to 0 with a length of 3
        buffer.position(2);
        byte[] sliceToMove = new byte[3];
        buffer.get(sliceToMove); // Read the part to move

        buffer.position(0);
        buffer.put(sliceToMove); // Write it back at the desired position
    }
}