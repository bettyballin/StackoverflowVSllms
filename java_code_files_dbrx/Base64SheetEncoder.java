import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Base64SheetEncoder {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        Hm hm = new Hm();
        hm.write(bos);

        byte[] sheetBytes = bos.toByteArray();
        String base64SheetBytes = Base64.getEncoder().encodeToString(sheetBytes);

        Req req = new Req();
        req.getSession().setAttribute("base64", base64SheetBytes);
    }
}

class Hm {
    public void write(ByteArrayOutputStream bos) throws IOException {
        // Dummy implementation
        bos.write("Dummy Data".getBytes());
    }
}

class Req {
    private Session session = new Session();

    public Session getSession() {
        return session;
    }
}

class Session {
    public void setAttribute(String key, String value) {
        // Dummy implementation
        System.out.println("Set attribute: " + key + " = " + value);
    }
}