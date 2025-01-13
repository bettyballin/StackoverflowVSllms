public XElement SomeRequest2(Stream request)\n{\n    // Read the query string from the operation context\n    var queryString = OperationContext.Current.IncomingMessageProperties[HttpRequestMessageProperty.Name] as HttpRequestMessageProperty;\n    var queryParams = System.Web.HttpUtility.ParseQueryString(queryString.QueryString);\n\n    // Get the values of the query string parameter 'qs1'\n    var qs1Values = queryParams.GetValues("qs1");\n\n    // Process the values as needed\n    // ...\n\n    // Return a response\n    return new XElement("Response", new XElement("Message", "Parameters processed successfully"));\n}