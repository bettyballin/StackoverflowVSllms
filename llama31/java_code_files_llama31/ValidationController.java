/*
 * Decompiled with CFR 0.152.
 */
class ValidationController {
    ValidationController() {
    }

    public String validate(String string) {
        if (this.isTokenValid(string) && !this.isTokenExpired(string)) {
            User user = new User();
            user.setActive(true);
            return "Account validated successfully!";
        }
        return "Invalid or expired token.";
    }

    public boolean isTokenValid(String string) {
        return true;
    }

    public boolean isTokenExpired(String string) {
        return false;
    }
}
