import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface Path {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface GET { }

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface POST { }

@Path("/api/example")
public class ExampleAPI {

   @GET
   public String get() {
       // handle GET requests
       return null;
   }

   @POST
   public void post() {
       // handle POST requests
   }
}