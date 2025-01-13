// Package and import statements
package com.example.app.services;

import com.example.oldframework.db.DataAccessObject;
import com.example.newframework.db.Entity;
import com.example.newframework.db.Repository;

// OldService class
public class OldService {
    private DataAccessObject dao;

    public OldService(DataAccessObject dao) {
        this.dao = dao;
    }

    // Methods using the old framework
    public void doSomethingOld() {
        // Use the DataAccessObject
        dao.doSomething();
    }
}

// NewService class
class NewService {
    private Repository repository;

    public NewService(Repository repository) {
        this.repository = repository;
    }

    // Methods using the new framework
    public void doSomethingNew() {
        // Use the Repository and Entity
        Entity entity = new Entity();
        repository.save(entity);
    }
}