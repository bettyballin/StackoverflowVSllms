import java.util.List;

public class LargeObject {
    private List<String> data;

    // Constructor
    public LargeObject(List<String> data) {
        this.data = data;
    }

    // other methods

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("LargeObject{data=[");
        int limit = Math.min(data.size(), 10);  // Limit to first 10 elements for example
        for (int i = 0; i < limit; i++) {
            if (i > 0) builder.append(", ");
            builder.append("...");
        }
        builder.append("...]}");
        return builder.toString();
    }

    public static void main(String[] args) {
    }
}