/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class FilePathChecker {
    public static void main(String[] stringArray) {
        String string;
        String string2 = System.getProperty("user.dir");
        String string3 = string2 + File.separator + (string = "../../../ggla/samples/obj/linux_x86");
        File file = new File(string3);
        if (file.exists()) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }
}
