/*
 * Decompiled with CFR 0.152.
 */
import java.util.ResourceBundle;

public class I18nHelper {
    public static void main(String[] stringArray) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.mycompany.myapp.CustomObject");
        String string = resourceBundle.getString("custom.object.message");
    }
}
