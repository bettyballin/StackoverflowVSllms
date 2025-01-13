try\n{\n    if (yourServiceProxy != null)\n    {\n        if (yourServiceProxy.State != CommunicationState.Faulted)\n        {\n            yourServiceProxy.Close();\n        }\n        else\n        {\n            yourServiceProxy.Abort();\n        }\n    }\n}\ncatch (CommunicationException)\n{\n    // Communication exceptions are normal when\n    // closing the connection.\n    yourServiceProxy.Abort();\n}\ncatch (TimeoutException)\n{\n    // Timeout exceptions are normal when closing\n    // the connection.\n    yourServiceProxy.Abort();\n}\ncatch (Exception)\n{\n    // Any other exception and you should \n    // abort the connection and rethrow to \n    // allow the exception to bubble upwards.\n    yourServiceProxy.Abort();\n    throw;\n}\nfinally\n{\n    // This is just to stop you from trying to \n    // close it again (with the null check at the start).\n    // This may not be necessary depending on\n    // your architecture.\n    yourServiceProxy = null;\n}