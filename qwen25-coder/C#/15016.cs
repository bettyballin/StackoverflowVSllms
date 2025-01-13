MyServiceClient proxy = new MyServiceClient();\n   using (new OperationContextScope(proxy.InnerChannel))\n   {\n       MessageHeaders headers = OperationContext.Current.OutgoingMessageHeaders;\n       headers.Add(MessageHeader.CreateHeader("Credentials", "http://mycompany.com/", "base64EncodedCredentials"));\n       // Call your service method\n       proxy.MyMethodCompleted += new EventHandler<MyMethodCompletedEventArgs>(proxy_MyMethodCompleted);\n       proxy.MyMethodAsync();\n   }