import java.lang.String;

public class User_8 {
    public final class User {
        @NotBlank(message = "{errorCode.name[not.blank]}")
        @Length(max = 80)
        private String name;

        @NotBlank(message = "{errorCode.email[not.blank]}")
        @Email(message = "{errorCode.email[email]}")
        @Length(max = 80, message="{errorCode.email[length]}")
        private String email;

        @NotBlank(message = "{errorCode.text[not.blank]}")
        @Length(max = 4000, message="{errorCode.text[length]}")
        private String text;
    }

    public static void main(String[] args) {
    }

    @interface NotBlank {
        String message() default "";
    }

    @interface Email {
        String message() default "";
    }

    @interface Length {
        int max() default Integer.MAX_VALUE;
        String message() default "";
    }
}