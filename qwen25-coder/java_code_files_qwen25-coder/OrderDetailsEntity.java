import java.lang.String;

public class OrderDetailsEntity {

    @Column(name = "OrderName")
    String orderName;

    public static void main(String[] args) {
    }
}

@interface Column {
    String name();
}