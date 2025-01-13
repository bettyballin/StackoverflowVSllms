/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestParam
 */
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class Controller {
    @PostMapping(value={"/your-endpoint"})
    public String yourMethod(@RequestParam(value="id") String[] stringArray) {
        return "Hello, World!";
    }

    public static void main(String[] stringArray) {
    }
}
