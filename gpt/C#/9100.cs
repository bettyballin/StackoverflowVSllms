// Silverlight Client\n   using SharedLibrary;\n\n   public void CallService()\n   {\n       var client = new MyServiceClient();\n       client.GetDataCompleted += (s, e) =>\n       {\n           MyDataContract data = e.Result;\n           // Use the data\n       };\n       client.GetDataAsync();\n   }