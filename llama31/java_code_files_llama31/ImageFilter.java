/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;

public class ImageFilter {
    private void medianFilterSquare(int[] nArray, int[] nArray2, int n, int n2, int n3) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        int n4 = n2;
        int n5 = n;
        int[] nArray3 = new int[n4 * n5];
        int[] nArray4 = new int[n4 * n5];
        int[] nArray5 = new int[n4 * n5];
        int n6 = 0;
        int n7 = 0;
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n5; ++j) {
                int n8 = nArray[n7];
                byteBuffer.putInt(n8);
                byteBuffer.flip();
                byte[] byArray = byteBuffer.array();
                nArray3[n6] = byArray[0] & 0xFF;
                nArray4[n6] = byArray[1] & 0xFF;
                nArray5[n6] = byArray[2] & 0xFF;
                ++n6;
                byteBuffer.clear();
            }
        }
    }

    public static void main(String[] stringArray) {
        ImageFilter imageFilter = new ImageFilter();
        int[] nArray = new int[100];
        int[] nArray2 = new int[100];
        imageFilter.medianFilterSquare(nArray, nArray2, 10, 10, 1);
    }
}
