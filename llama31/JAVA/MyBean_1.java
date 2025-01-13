import java.lang.String;
// MyBean.java
public class MyBean_1 {
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String render() {
        return "<div class='my-control'>" + label + "</div>";
    }

	public static void main(String[] args) {
	}
}