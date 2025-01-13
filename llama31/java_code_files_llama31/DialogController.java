/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Controller
 *  org.springframework.ui.Model
 *  org.springframework.web.bind.annotation.RequestMapping
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DialogController {
    @RequestMapping(value={"/hide-dialog"})
    public String hideDialog(Model model) {
        model.addAttribute("hideDialog", (Object)true);
        return "page";
    }

    public static void main(String[] stringArray) {
    }
}
