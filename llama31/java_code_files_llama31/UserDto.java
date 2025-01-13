/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class UserDto {
    private String name;
    private List<Contacts> contacts;

    public void setName(String string) {
        this.name = string;
    }

    public void setContacts(List<Contacts> list) {
        this.contacts = list;
    }

    public String getName() {
        return this.name;
    }

    public List<Contacts> getContacts() {
        return this.contacts;
    }

    public static void main(String[] stringArray) {
    }
}
