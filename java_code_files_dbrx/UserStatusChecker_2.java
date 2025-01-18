import java.lang.String;
class UserStatus {
    public static final int USER_ONLINE = 1;
    public static final int USER_OFFLINE = 2;
    public static final int USER_DISABLED = 3;
}

public class UserStatusChecker_2 {
    void checkUserStatus(int userStatus) {
        if (userStatus == UserStatus.USER_ONLINE) {
            // code to run when the user is online
        } else if (userStatus == UserStatus.USER_OFFLINE) {
            // code when the user is offline
        } else if (userStatus == UserStatus.USER_DISABLED) {
            // code when an account is disabled
        } else {
            throw new RuntimeException("Unknown state of the user");
        }
    }

    public static void main(String[] args) {
    }
}