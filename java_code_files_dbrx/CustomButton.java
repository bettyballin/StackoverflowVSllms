import java.lang.String;
import java.io.Serializable;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ManagedBean {
    String name();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ViewScoped {
}

@ManagedBean(name = "customButton")
@ViewScoped
public class CustomButton implements Serializable {
    private String text;
    private String styleClass;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getStyleClass() {
        return styleClass != null ? styleClass : "";
    }

    public static void main(String[] args) {
    }
}