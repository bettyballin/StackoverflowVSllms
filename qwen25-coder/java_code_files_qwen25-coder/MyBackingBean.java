import java.lang.String;

@interface ManagedBean { }

@interface ViewScoped { }

@ManagedBean
@ViewScoped
public class MyBackingBean {
    // Your fields, constructor, methods here

    public static void main(String[] args) {
    }
}