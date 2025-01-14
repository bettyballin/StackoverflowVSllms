import java.lang.String;

public class StripeSubscriptionCancellationService {
    static Client client = new Client();

    public static void main(String[] args) {
        client.subscriptions().cancel("SUBSCRIPTION_ID", "UPGRADING/DOWNGRADING", RequestOptions.builder().build());
    }
}

class Client {
    public Subscriptions subscriptions() {
        return new Subscriptions();
    }
}

class Subscriptions {
    public void cancel(String subscriptionId, String reason, RequestOptions options) {
        // Implementation
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