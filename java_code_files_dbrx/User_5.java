import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@interface NotBlank {
    String message() default "must not be blank";
}

public class User_5 {
   @NotBlank(message = "Username is mandatory")
   private String username;

   // ...

    public static void main(String[] args) {
    }
}