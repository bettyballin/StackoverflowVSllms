/*
 * Decompiled with CFR 0.152.
 */
public class RpcExample {
    public static void main(String[] stringArray) {
        Request request = new Request("example_request");
        Server server = new Server();
        try {
            Response response = server.processRequest(request);
            if (response != null) {
                System.out.println("Request processed successfully");
            } else {
                System.out.println("Request failed or timed out");
            }
        }
        catch (RuntimeException runtimeException) {
            System.out.println("Request failed due to server crash or storage failure");
        }
    }
}
