using System.ServiceModel.Description;\n   using System.ServiceModel.Dispatcher;\n\n   public class ExtendedPropertiesBehavior : IEndpointBehavior\n   {\n       public void AddBindingParameters(ServiceEndpoint endpoint, BindingParameterCollection bindingParameters) { }\n\n       public void ApplyClientBehavior(ServiceEndpoint endpoint, ClientRuntime clientRuntime)\n       {\n           clientRuntime.MessageInspectors.Add(new ExtendedPropertiesMessageInspector());\n       }\n\n       public void ApplyDispatchBehavior(ServiceEndpoint endpoint, EndpointDispatcher endpointDispatcher)\n       {\n           endpointDispatcher.DispatchRuntime.MessageInspectors.Add(new ExtendedPropertiesMessageInspector());\n       }\n\n       public void Validate(ServiceEndpoint endpoint) { }\n   }