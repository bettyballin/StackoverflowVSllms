using Raven.Client.Documents;\n\n   using (var store = new DocumentStore { Urls = new[] { "http://localhost:8080" }, Database = "MyDatabase" })\n   {\n       store.Initialize();\n       using (var session = store.OpenSession())\n       {\n           // Perform database operations\n       }\n   }