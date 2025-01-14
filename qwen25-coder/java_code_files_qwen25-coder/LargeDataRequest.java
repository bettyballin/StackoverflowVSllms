import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class LargeDataRequest {
    @JsonProperty("data")
    private List<String> data;

    // Getters and setters
    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}

public interface IMyWebServices {
    String processLargeData(LargeDataRequest request);

    public static void main(String[] args) {
    }
}