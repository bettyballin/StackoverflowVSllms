import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Assuming CategoryNotFoundException and ErrorResponse are custom classes
// You need to import them correctly or define them within the same package
import your.package.CategoryNotFoundException;
import your.package.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {
  
  @ExceptionHandler(CategoryNotFoundException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public ErrorResponse handleCategoryNotFoundException(CategoryNotFoundException e) {
    return new ErrorResponse("Invalid category ID", 422, e.getMessage());
  }

  public static void main(String[] args) {
    // This main method is not necessary for a typical Spring application,
    // as the application is started through a different mechanism.
    // However, to compile this class standalone with javac, it's fine to leave it.
  }
}