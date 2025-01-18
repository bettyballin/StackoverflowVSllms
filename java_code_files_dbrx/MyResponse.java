import lombok.Data;
import java.util.List;
import org.springframework.hateoas.RepresentationModel;

@Data
public class MyResponse extends RepresentationModel {
    private List<Item> items;

    public static void main(String[] args) {
    }
}