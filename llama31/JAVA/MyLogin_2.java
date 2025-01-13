import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

@ManagedBean
public class MyLogin_2_2 {
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent component = context.getViewRoot().findComponent("username");
        String someValue = (String) component.getAttributes().get("value");
        System.out.println(someValue); // prints "some_value"
    }

    public static void main(String[] args) {
        // For compilation purposes, this will remain empty as the init() method is intended
        // to be called by the JSF lifecycle, not from a main method directly.
    }
}