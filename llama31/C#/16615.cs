using (var service = new MyServiceClient())\n{\n    try\n    {\n        // Service operations...\n        service.Close();\n    }\n    catch (Exception ex)\n    {\n        // Handle exception...\n        service.Abort();\n    }\n}