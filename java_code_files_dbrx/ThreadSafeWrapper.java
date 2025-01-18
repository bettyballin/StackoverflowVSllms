import java.lang.String;

interface ThirdPartyLibraryAPI {
    void doSomething(); // hide a complex method call or sequence behind abstraction and make it look like single action.
}

// Wrapper class implementing the API to provide thread safety.
public class ThreadSafeWrapper implements ThirdPartyLibraryAPI{
    private final Object mutex = new Object();
    @Override
    public void doSomething(){
        synchronized(mutex){
            // complex sequence or third-party library call goes here
        }
    }

    public static void main(String[] args) {
    }
}