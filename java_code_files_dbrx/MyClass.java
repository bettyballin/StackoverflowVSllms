import java.util.Arrays;

public class MyClass {
    // UserStatus constants
    public static class UserStatus {
        public static final int USER_ONLINE = 1;
        public static final int USER_OFFLINE = 2;
        public static final int USER_UNDEFINED = 3;
    }

    void checkUserStatus(int userStatus, String UserLocation, String DeviceType) {
        Boolean[] conditionsMet = new Boolean[3]; // replace 2 with number of combinations +1 for default case
        int trueConditions = 0;

        // for each condition in table rows
        if ((userStatus == UserStatus.USER_ONLINE || userStatus == UserStatus.USER_UNDEFINED)
                && (UserLocation != null && UserLocation.equals("Europe"))) {
            conditionsMet[trueConditions++] = true;
        } else {
            conditionsMet[trueConditions++] = false;
        }

        if ((userStatus == UserStatus.USER_OFFLINE || userStatus == UserStatus.USER_UNDEFINED)
                && (DeviceType != null && DeviceType.equals("Mobile"))) {
            conditionsMet[trueConditions++] = true;
        } else {
            conditionsMet[trueConditions++] = false;
        }

        // ... add other rows from decision table here as per requirement,
        // remember to increment the next condition counter 'trueConditions++' every time

        if (Arrays.asList(conditionsMet).contains(Boolean.TRUE)) {
            // there was a true in conditions met array, execute default case code here if needed.
            // Here I am throwing an exception for illustrative purpose but you can change this
            // as per your application requirement.
            throw new RuntimeException("Default Case");
        } else {
            // all false which means no combination matched so return appropriate message
            // or do nothing as per requirements
            System.out.println("No Condition Met!");
        }
    }
}