/*
 * Decompiled with CFR 0.152.
 */
class PolicyEngine {
    PolicyEngine() {
    }

    public boolean evaluate(User user, Resource resource, Policy policy) {
        String[] stringArray = policy.rule.split(" AND ");
        boolean bl = true;
        for (String string : stringArray) {
            String[] stringArray2 = string.split("==");
            String string2 = stringArray2[0].trim();
            String string3 = stringArray2[1].trim();
            if (string2.equals("User.department")) {
                if (user.department.equals(string3)) continue;
                bl = false;
                break;
            }
            if (string2.equals("User.role")) {
                if (user.role.equals(string3)) continue;
                bl = false;
                break;
            }
            if (!string2.equals("Resource.department") || resource.department.equals(string3)) continue;
            bl = false;
            break;
        }
        return bl;
    }
}
