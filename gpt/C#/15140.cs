[WebInvoke(Method = "POST", UriTemplate = "MyMethod")]\npublic int MyMethod(MyMethodParams parameters)\n{\n    int foo = parameters.Foo;\n    string bar = parameters.Bar;\n\n    // Your logic here\n\n    return 0; // Return appropriate value\n}