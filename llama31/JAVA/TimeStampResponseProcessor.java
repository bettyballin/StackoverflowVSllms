import java.lang.String;

public class TimeStampResponseProcessor {
    public static void main(String[] args) {
        // Assuming resp and req are defined somewhere
        TimeStampResponse response = new TimeStampResponse(resp);
        response.validate(req);

        int status = response.getStatus();
        switch (status) {
            case TimeStampResponse.STATUS_GRANTED:
                System.out.println("Timestamp granted");
                // Now you can access the TimeStampToken and TimeStampInfo objects
                System.out.println(response.getTimeStampToken().getTimeStampInfo().getGenTime());
                break;
            case TimeStampResponse.STATUS_GRANTED_WITH_MODS:
                System.out.println("Timestamp granted with modifications");
                // You may want to check the modifications before accessing the TimeStampToken and TimeStampInfo objects
                break;
            case TimeStampResponse.STATUS_REJECTED:
                System.out.println("Timestamp request rejected");
                // You should not try to access the TimeStampToken and TimeStampInfo objects in this case
                break;
            case TimeStampResponse.STATUS_WAITING:
                System.out.println("Timestamp request is waiting to be processed");
                // You should wait and try again later
                break;
            case TimeStampResponse.STATUS_REVOCATION_WARNING:
                System.out.println("Revocation warning");
                // You may want to take action based on this warning
                break;
            case TimeStampResponse.STATUS_REVOCATION_NOTIFICATION:
                System.out.println("Revocation notification");
                // You should take action based on this notification
                break;
            default:
                System.out.println("Unknown status");
                // You should handle unknown status values
                break;
        }
    }
}