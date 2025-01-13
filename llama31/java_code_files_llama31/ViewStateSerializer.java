/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class ViewStateSerializer {
    public static void main(String[] stringArray) {
        ViewState viewState = new ViewState();
        viewState.setData("some data");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(viewState);
            objectOutputStream.close();
            String string = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
            System.out.println("Encoded ViewState: " + string);
        }
        catch (Exception exception) {
            System.out.println("Serialization failed: " + exception.getMessage());
        }
    }
}
