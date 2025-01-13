/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MyRunnable {
    MyRunnable() {
    }

    public static void main(String[] stringArray) throws Exception {
        String string;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println("Processed: " + string);
        }
    }
}
