var proxy = new YourServiceClient();\nproxy.Endpoint.Behaviors.Add(new CustomHeaderBehavior("test", "pass"));