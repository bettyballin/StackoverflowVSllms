import java.util.Date;

public class TimeStampChecker {
    public static void main(String[] args) {
        Response response = new Response();

        if(response != null && response.getTimeStampToken() != null){
            TimeStampInfo timeStampInfo = response.getTimeStampToken().getTimeStampInfo();
            if (timeStampInfo != null) {
                Date genTime = timeStampInfo.getGenTime();
                System.out.println("Generation Time: " + genTime);
            } else {
                System.err.println("No timestamp information in the response");
            }
        }
    }
}

class Response {
    public TimeStampToken getTimeStampToken() {
        return new TimeStampToken();
    }
}

class TimeStampToken {
    public TimeStampInfo getTimeStampInfo() {
        return new TimeStampInfo();
    }
}

class TimeStampInfo {
    public Date getGenTime() {
        return new Date();
    }
}