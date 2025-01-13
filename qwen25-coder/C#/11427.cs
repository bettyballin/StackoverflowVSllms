using System;\nusing System.IO;\nusing System.ServiceModel;\nusing System.ServiceModel.Channels;\nusing System.ServiceModel.Dispatcher;\n\npublic class MessageSizeLogger : IDispatchMessageInspector, IServiceBehavior\n{\n    public object AfterReceiveRequest(ref Message request, IClientChannel channel, InstanceContext instanceContext)\n    {\n        LogMessageSize(request, "Received");\n        return null;\n    }\n\n    public void BeforeSendReply(ref Message reply, object correlationState)\n    {\n        LogMessageSize(reply, "Sent");\n    }\n\n    private static void LogMessageSize(Message message, string direction)\n    {\n        if (message != null && !message.IsEmpty)\n        {\n            var buffer = message.GetBody<Stream>().ToArray();\n            Console.WriteLine($"{direction} Message Size: {buffer.Length} bytes");\n            // Replace Console.WriteLine with your logging implementation\n        }\n        else\n        {\n            Console.WriteLine($"{direction} Empty Message");\n        }\n    }\n\n    #region IServiceBehavior Members\n\n    public void Validate(ServiceDescription serviceDescription, ServiceHostBase serviceHostBase) {}\n\n    public void AddBindingParameters(ServiceDescription serviceDescription, ServiceHostBase serviceHostBase, Collection<ServiceEndpoint> endpoints, BindingParameterCollection bindingParameters) {}\n\n    public void ApplyDispatchBehavior(ServiceDescription serviceDescription, ServiceHostBase serviceHostBase)\n    {\n        foreach (ChannelDispatcher chDisp in serviceHostBase.ChannelDispatchers)\n        {\n            foreach (EndpointDispatcher epDisp in chDisp.Endpoints)\n            {\n                epDisp.DispatchRuntime.MessageInspectors.Add(this);\n            }\n        }\n    }\n\n    #endregion\n}