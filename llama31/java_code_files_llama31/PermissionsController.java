/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/api/permissions"})
public class PermissionsController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping
    public Map<String, Boolean> getPermissions() {
        Map<String, Boolean> map = this.permissionService.getUserPermissions();
        return map;
    }

    public static void main(String[] stringArray) {
    }
}
