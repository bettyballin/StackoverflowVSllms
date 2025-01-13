import java.lang.String;

public class DataEraser {
    public static void secureErase(byte[] data) {
        if (data == null) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
    }

    public static void main(String[] args) {
    }
}