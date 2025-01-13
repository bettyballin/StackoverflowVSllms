import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.lang.String;
import java.util.Base64;

public class ViewStateDeserializer {
    public static void main(String[] args) throws Exception {
        // Retrieve the encoded ViewState from the request parameter
        String encodedViewState = "your_view_state_string"; // replace with actual view state string
        java.servlet.http.HttpServletRequest request = null; // you need to get the request object from somewhere, e.g., a servlet

        // Deserialize the ViewState
        byte[] decodedBytes = Base64.getDecoder().decode(encodedViewState);
        ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        ViewState viewState = (ViewState) ois.readObject();
        ois.close();

        // Access the original data
        String data = viewState.getData();
        System.out.println(data);
    }
}

class ViewState implements java.io.Serializable {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}