/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.net.URL;

public class ResourceChecker {
    public static void main(String[] stringArray) {
        String string = "/ggla/samples/obj/linux_x86/your_executable";
        URL uRL = ResourceChecker.class.getResource(string);
        if (uRL != null) {
            File file = new File(uRL.getFile());
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }
}
