function handleEvent() {\n    DWR.setBatch(true);\n\n    // Make remote calls here\n    MyRemoteServerMethod.firstCall(param1, function(result) { /* callback code */ });\n    MyRemoteServerMethod.secondCall(param2, function(result) { /* callback code */ });\n\n    DWR.flush();  // This sends the batched requests\n}