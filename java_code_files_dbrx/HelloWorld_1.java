import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

// Example of stateless REST API design in Spring Boot

@RestController
public class HelloWorld_1 {

    static Map<Integer, String> db = new HashMap<>(); // This doesn't maintain any session data with server

    @RequestMapping("/user/{id}")
    public String getUserName(@PathVariable Integer id) {
        return db.get(id);
    }

    @PutMapping("/update")
    String updateDb(@RequestParam int key, @RequestBody String value){
       if(!db.containsKey(key)){
          db.put(key, value);
          return "Value added";
       }else{
           // return 409 conflict as a response header?
           throw new ConflictException();
       }
    }

    public static void main(String[] args) {
    }
}

@ResponseStatus(HttpStatus.CONFLICT)
class ConflictException extends RuntimeException {
    public ConflictException() {
        super("Conflict");
    }
}