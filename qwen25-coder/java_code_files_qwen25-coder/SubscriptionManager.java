import java.lang.String;
public class SubscriptionManager {
    Client client = new Client();

    {
        client.subscriptions().cancel("SUBSCRIPTION_ID", "CANCELLED_BY_USER", RequestOptions.builder().build());
    }

    public static void main(String[] args) {
    }
}

class Client {
    public Subscriptions subscriptions() {
        return new Subscriptions();
    }
}

class Subscriptions {
    public void cancel(String subscriptionId, String reason, RequestOptions options) {
    }
}

class RequestOptions {
    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        public RequestOptions build() {
            return new RequestOptions();
        }
    }
}