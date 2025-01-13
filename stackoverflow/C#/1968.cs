using (new TransactionScope())\n{\n    var server = new Server(PORT_NUMBER, VIRTUAL_PATH, PHYSICAL_PATH);\n    server.Start();\n    try\n    {\n        using (var ie = new IE())\n        {\n            // TODO: perform necessary testing using ie object\n        }\n    }\n    finally\n    {\n        server.Stop();\n    }\n}