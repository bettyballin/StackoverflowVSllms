var factory = new ChannelFactory<IServiceContract>(new WebHttpBinding(), "http://example.com/service");\nvar channel = factory.CreateChannel();\n\nvar requestData = new RequestData();\nHttpStatusCode statusCode;\nchannel.PutMethod(requestData, out statusCode);\n\nif (statusCode == HttpStatusCode.Created)\n{\n    Console.WriteLine("Resource created");\n}\nelse if (statusCode == HttpStatusCode.OK)\n{\n    Console.WriteLine("Resource updated");\n}