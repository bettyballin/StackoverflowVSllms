import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto_1 {
    public static final class UserDto {
        private final String name;

        @JsonCreator // Jackson annotation to parse JSON strings during construction of objects.
        public UserDto(@JsonProperty("username") String userName) {
            this.name = userName;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
    }
}