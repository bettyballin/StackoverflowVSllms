using System;\nusing System.Collections.ObjectModel;\nusing System.Net;\nusing System.ServiceModel;\nusing System.ServiceModel.Channels;\nusing System.ServiceModel.Description;\nusing System.ServiceModel.Dispatcher;\n\npublic class FaultedMessageInspector : IClientMessageInspector, IEndpointBehavior\n{\n    public void AddBindingParameters(ServiceEndpoint endpoint, BindingParameterCollection bindingParameters) { }\n\n    public void ApplyClientBehavior(ServiceEndpoint endpoint, ClientRuntime clientRuntime)\n    {\n        clientRuntime.MessageInspectors.Add(this);\n    }\n\n    public void ApplyDispatchBehavior(ServiceEndpoint endpoint, EndpointDispatcher endpointDispatcher) { }\n\n    public void Validate(ServiceEndpoint endpoint) { }\n\n    public object BeforeSendRequest(ref Message request, IClientChannel channel)\n    {\n        return null;\n    }\n\n    public void AfterReceiveReply(ref Message reply, object correlationState)\n    {\n        var httpResponse = (HttpWebResponse)((HttpWebRequest)reply.Properties[WebOperationContext.Current.IncomingResponse.PropertyNames.HttpResponse]).GetResponse();\n        if ((int)httpResponse.StatusCode >= 400)\n            throw new FaultException($"Error {httpResponse.StatusCode}: {httpResponse.StatusDescription}");\n    }\n}\n\npublic class MyFooFinderChannelFactory<T> : WebChannelFactory<T>\n{\n    public MyFooFinderChannelFactory(Uri remoteAddress)\n        : base(remoteAddress)\n    {\n        foreach (var endpoint in this.Endpoint.EndpointBehaviors)\n        {\n            if (endpoint is FaultedMessageInspector) return;\n        }\n\n        this.Endpoint.EndpointBehaviors.Add(new FaultedMessageInspector());\n    }\n}\n\n// Usage\nvar factory = new MyFooFinderChannelFactory<IFooFinder>(new Uri("http://api.example.com"));\nvar channel = factory.CreateChannel();\ntry\n{\n    var results = channel.Find(myApiKey, "foo");\n}\ncatch (FaultException fault)\n{\n    Console.WriteLine($"Caught an exception: {fault.Message}");\n}