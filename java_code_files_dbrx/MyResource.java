import java.lang.String;

@RestController
public class MyResource {

    private MapDecorator mapDelegate; // Assuming this is your decorate object where set & get methods are implemented.

    @POST
    public void set(@RequestBody String key, @PathVariable Object value){
        mapDelegate.set(key,value);
    }

    @GET
    public Object get(@RequestParam("key") String key){
        return mapDelegate.get(key);
    }

    public static void main(String[] args) {
    }
}

class MapDecorator {
    public void set(String key, Object value) {
        // implementation
    }

    public Object get(String key) {
        // implementation
        return null;
    }
}

@interface RestController {}
@interface POST {}
@interface GET {}
@interface RequestBody {}
@interface PathVariable {}
@interface RequestParam {
    String value();
}