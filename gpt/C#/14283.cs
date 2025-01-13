try\n{\n    // Call the COM object method here\n    comObject.SomeMethod();\n}\ncatch (System.Runtime.InteropServices.COMException comEx)\n{\n    // Handle the COM exception\n    Console.WriteLine($"COM Exception: {comEx.Message}");\n}\ncatch (Exception ex)\n{\n    // Handle other exceptions\n    Console.WriteLine($"General Exception: {ex.Message}");\n}\nfinally\n{\n    // Clean up resources if necessary\n    if (comObject != null)\n    {\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(comObject);\n        comObject = null;\n    }\n}