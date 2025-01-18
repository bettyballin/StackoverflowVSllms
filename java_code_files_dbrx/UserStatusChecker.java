import java.lang.String;

public class UserStatusChecker {

    void checkUserStatus(int userStatus) {

        switch (userStatus) {
            case UserStatus.USER_ONLINE:
                // code to run when the user is online
                break;
            case UserStatus.USER_OFFLINE:
                // code when User is offline
                break;
            case UserStatus.USER_DISABLED:
                // code when an account is disabled
                break;
            default:
                throw new RuntimeException("Unknown state of the user");
        }
    }

    public static void main(String[] args) {
    }
}

class UserStatus {
    public static final int USER_ONLINE = 1;
    public static final int USER_OFFLINE = 2;
    public static final int USER_DISABLED = 3;
}