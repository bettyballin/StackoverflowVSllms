interface IReadStream {
    int read(byte[] buffer, int offset, int len);
}

public class MyReadStream implements IReadStream {
    private byte[] data;
    private int position = 0;

    public MyReadStream(byte[] initialData) {
        this.data = initialData;
    }

    @Override
    public int read(byte[] buffer, int offset, int count) {
        int bytesRead = Math.min(count, data.length - position);
        System.arraycopy(data, position, buffer, offset, bytesRead);
        position += bytesRead;
        return bytesRead;
    }

    public static void main(String[] args) {
    }
}