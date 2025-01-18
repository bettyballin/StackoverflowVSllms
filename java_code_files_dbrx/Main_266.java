class MyStructure {
    public byte c;
    public int i;  // Assuming a 32-bit integer and alignment on a multiple of four bytes.
}

public class Main {
    public static void main(String[] args) {
        int size = sizeofBytes(MyStructure.class);
        // Write to binary file manually, applying any necessary padding:
        byte[] structureAsByteArray = new byte[size];

        MyStructure myStructInstance = new MyStructure();
        myStructInstance.c = (byte) 1; // Example value
        myStructInstance.i = 42;       // Example value

        structureAsByteArray[0] = myStructInstance.c; // byte values go directly into the array.

        writeIntToByteArrayAtOffset(structureAsByteArray, myStructInstance.i, 4); // Write integer at offset of four bytes for padding and alignment purposes.
    }

    public static int sizeofBytes(Class<?> cls) {
        // Assuming alignment and padding as in C structs.
        if (cls == MyStructure.class) {
            // byte c at offset 0 (1 byte)
            // 3 bytes padding
            // int i at offset 4 (4 bytes)
            // Total size = 8 bytes
            return 8;
        }
        return 0; // For other classes (not handled)
    }

    public static void writeIntToByteArrayAtOffset(byte[] array, int value, int offset) {
        array[offset]     = (byte) ((value >> 24) & 0xFF);
        array[offset + 1] = (byte) ((value >> 16) & 0xFF);
        array[offset + 2] = (byte) ((value >> 8) & 0xFF);
        array[offset + 3] = (byte) (value & 0xFF);
    }
}