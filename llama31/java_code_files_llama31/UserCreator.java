/*
 * Decompiled with CFR 0.152.
 */
public class UserCreator {
    public static void main(String[] stringArray) {
        String string = PasswordGenerator.generatePassword((int)12);
        User user = new User("admin", string, "admin@example.com");
        System.out.println("Generated Password: " + string);
        System.out.println("Admin User: " + user.username);
        System.out.println("Admin Email: " + user.email);
    }
}
