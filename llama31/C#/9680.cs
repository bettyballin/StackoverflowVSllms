public class CustomUserNamePasswordValidator : UserNamePasswordValidator\n{\n    public override void Validate(string userName, string password)\n    {\n        // Validate the credentials against your database or authentication system\n        if (/* credentials are invalid */)\n        {\n            throw new SecurityTokenException("Invalid credentials");\n        }\n    }\n}\n\npublic class AuthenticationMessageInspector : IDispatchMessageInspector\n{\n    public object AfterReceiveRequest(ref Message request, IClientChannel channel, InstanceContext instanceContext)\n    {\n        var headers = request.Headers;\n        var authHeader = headers.FindHeader("Authorization", "http://schemas.microsoft.com/ws/2008/06/identity/securitytokens");\n        if (authHeader != -1)\n        {\n            var credentialString = headers.GetHeader<string>(authHeader).ToString();\n            var credentials = credentialString.Split(':');\n            if (credentials.Length == 2)\n            {\n                var validator = new CustomUserNamePasswordValidator();\n                validator.Validate(credentials[0], credentials[1]);\n            }\n        }\n        return null;\n    }\n\n    public void BeforeSendReply(ref Message reply, object correlationState)\n    {\n    }\n}\n\n[ServiceContract]\npublic interface IService\n{\n    [OperationContract]\n    [WebInvoke(Method = "GET", UriTemplate = "")]\n    string GetData();\n}\n\npublic class Service : IService\n{\n    public string GetData()\n    {\n        return "Hello, world!";\n    }\n}\n\npublic class CustomServiceHost : ServiceHost\n{\n    public CustomServiceHost(Type serviceType, params Uri[] baseAddresses) : base(serviceType, baseAddresses) { }\n\n    protected override void OnOpening()\n    {\n        base.OnOpening();\n        var inspector = new AuthenticationMessageInspector();\n        foreach (var endpoint in Description.Endpoints)\n        {\n            endpoint.Behaviors.Add(new DispatchBehavior { MessageInspectors = { inspector } });\n        }\n    }\n}