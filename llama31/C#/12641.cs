using System.Net.Http;\n\n// Create an HTTP server\nvar httpServer = new HttpServer();\n\n// Configure the server to listen on port 8080\nhttpServer.ListenAsync(new[] { "http://localhost:8080/" }, async (context) =>\n{\n    // Handle incoming requests\n}).Wait();