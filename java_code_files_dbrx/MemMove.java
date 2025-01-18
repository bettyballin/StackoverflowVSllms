// System.arraycopy as memmove alternative
public class MemMove {
    public byte[] memMove(byte[] src, int fromIndex, int toIndex) {
        final int length = fromIndex + (src.length - toIndex);
        byte[] dest = new byte[length];
        // Copy from the end of source array towards its beginning
        System.arraycopy(src, Math.max(0, src.length - length), dest, 0, Math.min(src.length, length));
        /* copy remainder in target */
        return dest;
    }
}