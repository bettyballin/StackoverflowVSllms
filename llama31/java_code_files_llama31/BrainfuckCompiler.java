/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class BrainfuckCompiler {
    public static void main(String[] stringArray) throws Exception {
        String string = "++++++++++[>+>+++>+++++++>++++++++++<<<<-]>++.>+.+++++++..+++.>+++++++++++++++.>+.<<+++++++++++++++.>.";
        byte[] byArray = BrainfuckCompiler.compile(string);
    }

    public static byte[] compile(String string) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.write(202);
        dataOutputStream.write(254);
        dataOutputStream.write(1);
        block7: for (char c : string.toCharArray()) {
            switch (c) {
                case '+': {
                    dataOutputStream.write(96);
                    continue block7;
                }
                case '-': {
                    dataOutputStream.write(100);
                    continue block7;
                }
                case '<': {
                    dataOutputStream.write(97);
                    continue block7;
                }
                case '>': {
                    dataOutputStream.write(101);
                    continue block7;
                }
                case '.': {
                    dataOutputStream.write(98);
                    dataOutputStream.write(1);
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
