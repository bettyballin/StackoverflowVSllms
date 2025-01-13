using NeoLoad;\n\nclass MyScript : Script\n{\n    public override void Run()\n    {\n        // Create a new HTTP request\n        HttpRequest request = new HttpRequest("http://mywebapp.com");\n\n        // Add headers and parameters\n        request.Headers.Add("Accept", "text/html");\n        request.Parameters.Add("username", "john");\n\n        // Send the request\n        HttpResponse response = request.Send();\n\n        // Check the response status code\n        if (response.StatusCode != 200)\n        {\n            // Log an error\n            Log.Error("Invalid response status code");\n        }\n    }\n}