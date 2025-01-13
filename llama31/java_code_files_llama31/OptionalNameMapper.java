/*
 * Decompiled with CFR 0.152.
 */
import java.util.Optional;

public class OptionalNameMapper {
    Optional<String> name = Optional.ofNullable(null);
    String fullName = this.name.map(String::toUpperCase).orElse(null);

    public static void main(String[] stringArray) {
        OptionalNameMapper optionalNameMapper = new OptionalNameMapper();
        System.out.println(optionalNameMapper.fullName);
    }
}
