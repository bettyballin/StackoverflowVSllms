/*
 * Decompiled with CFR 0.152.
 */
public class UserCommand {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public static void main(String[] stringArray) {
        UserCommand userCommand = new UserCommand();
        userCommand.setName("John Doe");
        System.out.println(userCommand.getName());
    }
}
