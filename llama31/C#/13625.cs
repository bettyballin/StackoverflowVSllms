// Generate the client and server code using the protobuf compiler\n// and the Grpc.Tools NuGet package\n\n// Server implementation\npublic class GreeterService : Greeter.GreeterBase\n{\n    public override async Task<SayHelloResponse> SayHello(SayHelloRequest request)\n    {\n        return new SayHelloResponse { Message = $"Hello, {request.Name}!" };\n    }\n}\n\n// Client usage\nvar channel = new Channel("localhost:5000", ChannelCredentials.Insecure);\nvar client = new Greeter.GreeterClient(channel);\n\nvar request = new SayHelloRequest { Name = "John" };\nvar response = await client.SayHelloAsync(request);\n\nConsole.WriteLine(response.Message);