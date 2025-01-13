using System;\nusing System.ServiceModel;\n\npublic class MyServiceHostFactory : ServiceHostFactory\n{\n    protected override ServiceHost CreateServiceHost(Type serviceType, Uri[] baseAddresses)\n    {\n        // Create a new instance of the service host\n        var serviceHost = new ServiceHost(serviceType, baseAddresses);\n\n        // Define your custom binding\n        WSHttpBinding wsHttpBinding = new WSHttpBinding();\n        wsHttpBinding.MaxReceivedMessageSize = 65535; // Set whatever value you need\n\n        // Add an endpoint using the custom binding\n        serviceHost.AddServiceEndpoint(typeof(IMyService), wsHttpBinding, "MyService");\n\n        return serviceHost;\n    }\n}