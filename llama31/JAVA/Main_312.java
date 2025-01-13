// Define the Keychain class in com/tolsma/keychain/Keychain.java
package com.tolsma.keychain;

import java.util.ArrayList;
import java.util.List;

public class Keychain {
    private List<PasswordItem> items = new ArrayList<>();

    public void add(PasswordItem item) {
        items.add(item);
    }
}

// Define the PasswordItem class in com/tolsma/keychain/PasswordItem.java
package com.tolsma.keychain;

public class PasswordItem {
    private String application;
    private String service;
    private String username;
    private String password;

    public PasswordItem(String application, String service, String username, String password) {
        this.application = application;
        this.service = service;
        this.username = username;
        this.password = password;
    }
}

// Your Main class remains the same
public class Main_312 {
    public static void main(String[] args) {
        // Create a Keychain instance
        com.tolsma.keychain.Keychain keychain = new com.tolsma.keychain.Keychain();

        // Create a PasswordItem instance
        com.tolsma.keychain.PasswordItem item = new com.tolsma.keychain.PasswordItem("Twitter Client", "twitter.com", "username", "password");

        // Add the item to the Keychain
        keychain.add(item);
    }
}