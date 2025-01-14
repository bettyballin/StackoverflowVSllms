import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class HeaderCaptorResponseWrapper extends HttpServletResponseWrapper {

    private final List<String> headerNames = new ArrayList<>();
    private final List<List<Object>> headers = new ArrayList<>();

    public HeaderCaptorResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public void addHeader(String name, String value) {
        int index = getIndex(name);
        checkHeadersIndex(index);
        headers.get(index).add(value);
    }

    @Override
    public void setHeader(String name, String value) {
        int index = getIndex(name);
        if (index == -1) {
            headerNames.add(name);
            List<Object> values = new ArrayList<>();
            values.add(value);
            headers.add(values);
        } else {
            headers.get(index).clear();
            headers.get(index).add(value);
        }
    }

    private int getIndex(String name) {
        for (int i = 0; i < headerNames.size(); i++) {
            if (headerNames.get(i).equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public String getCapturedHeader(String name) {
        int index = getIndex(name);
        if (index == -1 || headers.get(index).isEmpty()) {
            return null;
        } else {
            return (String) headers.get(index).get(0); // Only get the first value for simplicity
        }
    }

    public Enumeration<String> getCapturedHeaders() {
        return Collections.enumeration(headerNames);
    }

    private void checkHeadersIndex(int index) {
        if (headers.size() <= index) {
            while (headers.size() <= index) {
                headers.add(new ArrayList<>());
            }
        }
    }

    public static void main(String[] args) {
    }
}