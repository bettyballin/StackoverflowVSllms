/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RestController
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YourController {
    @GetMapping(value={"/YourMethod"})
    public String yourMethod() {
        return "YourValue";
    }

    public static void main(String[] stringArray) {
    }
}
