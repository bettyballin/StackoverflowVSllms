import java.lang.String;

public class instance {

    interface IMyMessageData {
        // methods
    }

    IMyMessageData messageFromLive = getMessageFromLiveService(); // Returns MyMyLiveMessageData class instance for Live Webservice.
    IMyMessageData messageFromTest = gettMessageFromTestService(); // Return MyMyTestMessageData class Instance for Testing Webservice

    public static void main(String[] args) {
    }

    private IMyMessageData getMessageFromLiveService() {
        // Returns MyMyLiveMessageData class instance for Live Webservice.
        return null;
    }

    private IMyMessageData gettMessageFromTestService() {
        // Return MyMyTestMessageData class Instance for Testing Webservice
        return null;
    }
}