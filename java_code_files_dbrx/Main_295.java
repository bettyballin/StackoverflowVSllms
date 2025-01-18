public class Main {
    public static void main(String[] args) {
        // Creating a mock object for class NetworkDevice
        NetworkDevice device = new NetworkDevice() {
            @Override
            public String getResponse() {
                return "Yes";
            }
        };

        // Example usage
        String response = device.getResponse();
        System.out.println("Response: " + response); // This will print "Response: Yes"
    }
}

// Assuming the NetworkDevice class is something like this
class NetworkDevice {
    public String getResponse() {
        // Original implementation (will be mocked)
        return "No";
    }
}