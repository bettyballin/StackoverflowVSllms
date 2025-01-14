import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.rmi.Remote;
import java.rmi.RemoteException;

interface YourRemoteInterface extends Remote {
    Map<String, ArrayList<String>> remoteGetCustomerNameNumbers() throws RemoteException;
}

public class YourRemoteImplementation implements YourRemoteInterface {
    @Override
    public Map<String, ArrayList<String>> remoteGetCustomerNameNumbers() throws RemoteException {
        ArrayList<String> customerNumberList = new ArrayList<>();
        ArrayList<String> customerNameList = new ArrayList<>();

        // Database lookup and populate lists

        Map<String, ArrayList<String>> result = new LinkedHashMap<>();
        result.put("customerNumbers", customerNumberList);
        result.put("customerNames", customerNameList);

        return result;
    }
}