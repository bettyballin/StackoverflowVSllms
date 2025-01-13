/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.mindrot.jbcrypt.BCrypt
 */
import org.mindrot.jbcrypt.BCrypt;

public class Main_179 {
    public static void main(String[] stringArray) {
        String string = "mysecretpassword";
        String string2 = BCrypt.gensalt();
        String string3 = BCrypt.hashpw((String)string, (String)string2);
        System.out.println("Hashed Password: " + string3);
    }
}
