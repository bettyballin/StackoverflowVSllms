/*
 * Decompiled with CFR 0.152.
 */
import java.io.FilePermission;
import java.net.SocketPermission;
import java.security.Permission;
import java.security.Permissions;
import java.security.Policy;
import java.security.ProtectionDomain;

public class GrantPermissions {
    public static void main(String[] stringArray) {
        final Permissions permissions = new Permissions();
        permissions.add(new FilePermission("<<ALL FILES>>", "read, write, execute"));
        permissions.add(new SocketPermission("*", "connect, accept"));
        Policy.setPolicy(new Policy(){

            @Override
            public boolean implies(ProtectionDomain protectionDomain, Permission permission) {
                return permissions.implies(permission);
            }
        });
    }
}
