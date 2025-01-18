// Sample code to illustrate OAuth authentication flow using Twitter API

public class TwitterAuthExample {

    private Activity activity;  // Assume activity is initialized somewhere

    public void authenticate() {
        TwitterAuthClient authClient = new TwitterAuthClient();
        authClient.authorize(activity, new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                TwitterSession session = result.data;
                String twitterUsername = session.getUserName();
                // Additional logic can be added here
            }

            @Override
            public void failure(TwitterException exception) {
                // handle error case, e.g., show a Toast message
            }
        });
    }
}

// Stub definitions to make the code compile

class Activity {
    // Empty stub class
}

class TwitterAuthClient {
    public void authorize(Activity activity, Callback<TwitterSession> callback) {
        // Simulate a successful authorization for demonstration
        callback.success(new Result<TwitterSession>(new TwitterSession(), null));
    }
}

class TwitterSession {
    public String getUserName() {
        return "SampleUser";
    }
}

class TwitterException extends Exception {
    // Empty stub class
}

class Result<T> {
    public T data;

    public Result(T data, Object response) {
        this.data = data;
    }
}

abstract class Callback<T> {
    public abstract void success(Result<T> result);

    public abstract void failure(TwitterException exception);
}