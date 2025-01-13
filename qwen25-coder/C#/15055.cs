[OperationContract]\n[WebGet(ResponseFormat = WebMessageFormat.Xml, UriTemplate = "SomeRequest?qs1={qs1}")]\nXElement SomeRequest(string qs1)\n{\n    // Split the query string parameter by commas (or another delimiter) into an array or list\n    var queryStringValues = qs1.Split(',');\n\n    // Now you can work with queryStringValues, which is a string array of all qs1 values provided.\n    // For demonstration, let's assume we are just creating XML to return based on these values.\n\n    var xmlBuilder = new XElement("Parameters",\n        from value in queryStringValues\n        select new XElement("Parameter", value)\n    );\n\n    return xmlBuilder;\n}