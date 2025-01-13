import java.lang.String;
public class Main_82 {
    public static void main(String[] args) {
        byte[] byteArray = {0x12, 0x34, 0x56, 0x78};

        for (byte b : byteArray) {
            for (int i = 7; i >= 0; i--) {
                int bit = (b >> i) & 1;
                System.out.print(bit);
            }
            System.out.println();
        }
    }
}