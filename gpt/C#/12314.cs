public class MyServiceClient : ClientBase<IMyService>, IMyService\n{\n    public MyServiceClient(NetTcpBinding binding, EndpointAddress address)\n        : base(binding, address) { }\n\n    public string MyMethod(string input)\n    {\n        return Channel.MyMethod(input);\n    }\n}