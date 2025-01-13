/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TravelController {
    @RequestMapping(value={"/travel/us/{from}/{to}/{date}/{time}/{departure}/"}, method={RequestMethod.GET})
    public String getTravelInfo(@PathVariable String string, @PathVariable String string2, @PathVariable String string3, @PathVariable String string4, @PathVariable String string5) {
        return "travel-info";
    }
}
