var basicHttpBinding = new BasicHttpBinding(BasicHttpSecurityMode.None);\nbasicHttpBinding.UseDefaultWebProxy = false;\n// Alternatively, if you want to explicitly set it\n// basicHttpBinding.ProxyAddress = null;\n\n// Set the endpoint using this binding\nEndpointAddress address = new EndpointAddress("http://your.service.url");\nChannelFactory<IYourService> factory = new ChannelFactory<IYourService>(basicHttpBinding, address);\nIYourService serviceClient = factory.CreateChannel();