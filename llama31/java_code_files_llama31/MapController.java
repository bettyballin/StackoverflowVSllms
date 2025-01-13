/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class MapController {
    @GetMapping(value={"/service/{x}/{y}/{z}"})
    public String myMethod(@PathVariable String string, @PathVariable String string2, @PathVariable String string3) {
        return "";
    }

    public static void main(String[] stringArray) {
    }
}
