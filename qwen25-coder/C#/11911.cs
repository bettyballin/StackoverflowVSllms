var netTcpBinding = new NetTcpBinding(SecurityMode.None);\nnetTcpBinding.UseDefaultWebProxy = false; // Although this is not used for NetTcpBinding\n\n// Set the endpoint using this binding\nEndpointAddress address2 = new EndpointAddress("net.tcp://your.service.url");\nChannelFactory<IYourService> factory2 = new ChannelFactory<IYourService>(netTcpBinding, address2);\nIYourService serviceClient2 = factory2.CreateChannel();