public void Action()\n{\n    var queryString = Request.QueryString;\n\n    // Example of accessing a specific parameter\n    string id = queryString["id"];\n\n    // Iterate through all parameters\n    foreach (var key in queryString.AllKeys)\n    {\n        string value = queryString[key];\n        // Do something with the key and value\n    }\n}