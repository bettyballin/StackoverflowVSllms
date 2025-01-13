/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.ui.Model
 *  org.springframework.web.bind.annotation.GetMapping
 */
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ExampleController {
    @GetMapping(value={"/example"})
    public String example(Model model) {
        model.addAttribute("data", (Object)"Hello, World!");
        return "example";
    }

    public static void main(String[] stringArray) {
    }
}
