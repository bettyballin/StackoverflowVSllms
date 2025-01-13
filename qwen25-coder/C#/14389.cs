public class AuthenticationBehavior : IEndpointBehavior\n{\n    public void AddBindingParameters(ServiceEndpoint endpoint, BindingParameterCollection bindingParameters)\n    {\n    }\n\n    public void ApplyClientBehavior(ServiceEndpoint endpoint, ClientRuntime clientRuntime)\n    {\n    }\n\n    public void ApplyDispatchBehavior(ServiceEndpoint endpoint, EndpointDispatcher endpointDispatcher)\n    {\n        endpointDispatcher.DispatchRuntime.MessageInspectors.Add(new AuthenticationInspector());\n    }\n\n    public void Validate(ServiceEndpoint endpoint)\n    {\n    }\n}