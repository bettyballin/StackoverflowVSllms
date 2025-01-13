using System;\nusing System.ServiceModel.Description;\n\npublic class DynamicProxyFactory\n{\n    public static object CreateProxy(string wsdlUri, string endpointAddress)\n    {\n        // Create a metadata importer\n        var importer = new WsdlImporter();\n\n        // Import the WSDL\n        var serviceContracts = importer.ImportAllContractsFrom(wsdlUri);\n\n        // Create a service contract\n        var contract = serviceContracts[0];\n\n        // Create a binding\n        var binding = new BasicHttpBinding();\n\n        // Create an endpoint address\n        var endpoint = new EndpointAddress(endpointAddress);\n\n        // Create a channel factory\n        var channelFactory = new ChannelFactory(contract, binding, endpoint);\n\n        // Create a proxy\n        var proxy = channelFactory.CreateChannel();\n\n        return proxy;\n    }\n}\n\n// Usage:\nvar wsdlUri = new Uri("http://localhost:8080/MyService?wsdl");\nvar endpointAddress = "http://localhost:8080/MyService";\n\nvar proxy = DynamicProxyFactory.CreateProxy(wsdlUri.ToString(), endpointAddress);\n\n// Use the proxy to call the service\nvar result = ((IMyContract)proxy).MyMethod();