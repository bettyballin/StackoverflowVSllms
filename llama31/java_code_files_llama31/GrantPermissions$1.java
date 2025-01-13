/*
 * Decompiled with CFR 0.152.
 */
import java.security.Permission;
import java.security.Permissions;
import java.security.Policy;
import java.security.ProtectionDomain;

static class GrantPermissions.1
extends Policy {
    final /* synthetic */ Permissions val$permissions;

    GrantPermissions.1(Permissions permissions) {
        this.val$permissions = permissions;
    }

    @Override
    public boolean implies(ProtectionDomain protectionDomain, Permission permission) {
        return this.val$permissions.implies(permission);
    }
}
