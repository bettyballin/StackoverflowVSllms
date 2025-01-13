/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestParam
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class RequestParamController {
    @GetMapping(value={"/service"})
    public String myMethod(@RequestParam String string, @RequestParam String string2, @RequestParam String string3) {
        return "Hello, World!";
    }

    public static void main(String[] stringArray) {
    }
}
