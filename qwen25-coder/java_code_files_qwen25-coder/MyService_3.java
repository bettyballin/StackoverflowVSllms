// Module: mypersistence
// File: module-info.java
module mypersistence {
    exports mypersistence;
}

// Module: mypersistence
// File: mypersistence/EntityManager.java
package mypersistence;

public interface EntityManager {
    // Define necessary methods if required
}

// Module: com.example.modularapp
// File: module-info.java
module com.example.modularapp {
    requires mypersistence;

    exports com.example.service;
}

// Module: com.example.modularapp
// File: com/example/service/MyService.java
package com.example.service;

import mypersistence.EntityManager;

public class MyService {
    private final EntityManager em;

    public MyService(EntityManager em) {
        this.em = em;
    }

    // Service methods here
}