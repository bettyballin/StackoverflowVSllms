[WebGet(UriTemplate = "search/?api_key={key}&query={query}", BodyStyle = WebMessageBodyStyle.Bare)]\n[OperationContract]\npublic XElement Find(string key, string query)\n{\n    var context = WebOperationContext.Current;\n    var customContext = new CustomWebOperationContext(context);\n    customContext.ThrowIfError();\n\n    // Rest of your implementation\n}