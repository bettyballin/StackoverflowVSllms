/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.PutMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/restapi/myobject"})
public class MyObjectController {
    @GetMapping(value={"/{id}"})
    public MyObject getResource(@PathVariable Long l) {
        return null;
    }

    @PutMapping(value={"/{id}"})
    public MyObject updateResource(@PathVariable Long l, @RequestBody MyObject myObject) {
        return null;
    }

    public static void main(String[] stringArray) {
        System.out.println("This is a Spring Boot application. Run it with Spring Boot framework.");
    }
}
