var factory = new WebChannelFactory<IFooFinder>(new Uri("http://api.example.com"));\nfactory.Endpoint.EndpointBehaviors.Add(new HttpErrorBehavior());\nvar channel = factory.CreateChannel();\n\ntry\n{\n    var results = channel.Find(myApiKey, "foo");\n    // Process results\n}\ncatch (WebException ex)\n{\n    // Handle the exception\n    Console.WriteLine(ex.Message);\n}