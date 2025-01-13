/*
 * Decompiled with CFR 0.152.
 */
public class UserMapper {
    public String getUserName(String string) {
        if (string.equals("1")) {
            return "User 1";
        }
        if (string.equals("2")) {
            return "User 2";
        }
        if (string.equals("3")) {
            return "User 3";
        }
        return "Unknown User";
    }

    public static void main(String[] stringArray) {
        UserMapper userMapper = new UserMapper();
        System.out.println(userMapper.getUserName("1"));
        System.out.println(userMapper.getUserName("2"));
        System.out.println(userMapper.getUserName("3"));
        System.out.println(userMapper.getUserName("4"));
    }
}
