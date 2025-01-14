// BetaListExample.java
import java.util.List;
import com.betalist.api.*;

public class BetaListExample {
    public static void main(String[] args) throws Exception {
        ApiClient client = new ApiClient("YOUR_API_TOKEN");
        List<Tester> testers = client.getTesters();
        System.out.println("Number of Testers: " + testers.size());
    }
}

// File: com/betalist/api/ApiClient.java
package com.betalist.api;

import java.util.List;
import java.util.ArrayList;

public class ApiClient {
    private String apiToken;

    public ApiClient(String apiToken) {
        this.apiToken = apiToken;
    }

    public List<Tester> getTesters() {
        return new ArrayList<Tester>();
    }
}

// File: com/betalist/api/Tester.java
package com.betalist.api;

public class Tester {
    // Define Tester class contents
}