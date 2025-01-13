/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.http.ResponseEntity
 *  org.springframework.web.bind.annotation.ModelAttribute
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RestController
 */
import java.security.Principal;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutosaveController {
    @PostMapping(value={"/autosave"})
    public ResponseEntity<String> autosave(@ModelAttribute MyForm myForm, Principal principal) {
        HashMap<String, MyForm> hashMap = new HashMap<String, MyForm>();
        hashMap.put(principal.getName(), myForm);
        return ResponseEntity.ok((Object)"Autosaved!");
    }

    public static void main(String[] stringArray) {
    }
}
