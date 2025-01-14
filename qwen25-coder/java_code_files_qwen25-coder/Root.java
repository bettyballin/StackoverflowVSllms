import java.lang.String;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Root {
    @XmlElement(name = "emulate")
    @XmlJavaTypeAdapter(BooleanToNumberAdapter.class)
    private Boolean emulate;

    // Getters and setters here
    public Boolean getEmulate() {
        return emulate;
    }

    public void setEmulate(Boolean emulate) {
        this.emulate = emulate;
    }

    public static void main(String[] args) {
    }
}

class BooleanToNumberAdapter extends XmlAdapter<String, Boolean> {
    @Override
    public Boolean unmarshal(String v) throws Exception {
        if (v == null) {
            return null;
        }
        return "1".equals(v);
    }

    @Override
    public String marshal(Boolean v) throws Exception {
        if (v == null) {
            return null;
        }
        return v ? "1" : "0";
    }
}