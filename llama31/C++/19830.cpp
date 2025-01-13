// MMDB (ExtremeDB) setup\nexdb::Database db;\ndb.open("mydb");\n\n// ODB-like layer setup\nclass MyObjectDB {\npublic:\n    void store(MyObject* obj) {\n        // Serialize obj to a byte array\n        byte* data = serializeObject(obj);\n        size_t dataSize = getObjectSize(obj);\n\n        // Insert data into MMDB\n        exdb:: Transaction txn = db.beginTransaction();\n        txn.insert(data, dataSize);\n        txn.commit();\n    }\n\n    MyObject* retrieve(uint64_t objectId) {\n        // Retrieve data from MMDB\n        exdb::Transaction txn = db.beginTransaction();\n        byte* data = txn.get(objectId);\n        txn.commit();\n\n        // Deserialize data to a MyObject instance\n        return deserializeObject(data);\n    }\n};\n\n// Usage example\nMyObjectDB odb;\nMyObject* obj = new MyObject();\nobj->setFoo("bar");\n\nodb.store(obj);\n\nuint64_t objectId = odb.getObjectId(obj);\nMyObject* retrievedObj = odb.retrieve(objectId);