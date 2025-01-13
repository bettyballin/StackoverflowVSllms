import java.util.List;

public class CustomerData {
    private List<String> customerNumbers;
    private List<String> customerNames;

    // getters and setters
    public List<String> getCustomerNumbers() {
        return customerNumbers;
    }

    public void setCustomerNumbers(List<String> customerNumbers) {
        this.customerNumbers = customerNumbers;
    }

    public List<String> getCustomerNames() {
        return customerNames;
    }

    public void setCustomerNames(List<String> customerNames) {
        this.customerNames = customerNames;
    }
}

interface RemoteCustomerData {
    public CustomerData remoteGetCustomerNameNumbers() throws java.rmi.RemoteException;
}

public class Main {
    public static void main(String[] args) {
    }
}