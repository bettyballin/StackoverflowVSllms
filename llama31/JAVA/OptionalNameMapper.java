import java.util.Optional;

public class OptionalNameMapper {
    Optional<String> name = Optional.ofNullable(null);
    String fullName = name.map(String::toUpperCase).orElse(null); // fullName will be null if name is null

    public static void main(String[] args) {
        OptionalNameMapper mapper = new OptionalNameMapper();
        System.out.println(mapper.fullName);
    }
}