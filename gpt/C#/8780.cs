MyServiceClient client = new MyServiceClient();\n    client.GetDataCompleted += (s, e) =>\n    {\n        if (e.Error == null)\n        {\n            var data = e.Result;\n            // Use the data in your Silverlight application\n        }\n    };\n    client.GetDataAsync("someId");