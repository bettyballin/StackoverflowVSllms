import java.lang.String;

public class JSFActionListener {

    public String update() {
        // ... your regular validation and DB persistence logic here
        if (FacesContext.getCurrentInstance().getMaximumSeverity() != null
                && FacesContext.getCurrentInstance().getMaximumSeverity().compareTo(FacesMessage.SEVERITY_ERROR) >= 0) {
            return "failed"; // this will now cause redirection specified in `faces-config.xml` (and possibly also a Seam Page xml for more complex cases).
        } else {
            // you can add other action strings to navigate from here if needed, e.g.:
            return "/foo?id=" + getInstanceId();  // this will redirect the browser with current instance id as the parameter (assuming that url is correctly rewritten on your container)
        }
    }

    public String getInstanceId() {
        return ""; // dummy implementation
    }

    public static void main(String[] args) {
    }

}

class FacesContext {
    public static FacesContext getCurrentInstance() {
        return new FacesContext();
    }

    public Severity getMaximumSeverity() {
        return new Severity();
    }

    public static class Severity implements Comparable<Severity> {
        @Override
        public int compareTo(Severity other) {
            return 0;
        }
    }
}

class FacesMessage {
    public static FacesContext.Severity SEVERITY_ERROR = new FacesContext.Severity();
}