/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;

public class ResourceLoader {
    public static void main(String[] stringArray) {
        ResourceLoader resourceLoader = new ResourceLoader();
        resourceLoader.loadResource();
    }

    public void loadResource() {
        String string = "map.mp";
        InputStream inputStream = this.getClass().getResourceAsStream(string);
        if (inputStream != null) {
            System.out.println("File found");
        } else {
            System.out.println("File not found");
        }
    }
}
