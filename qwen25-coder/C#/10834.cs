public void Action()\n{\n    NameValueCollection queryString = Request.QueryString;\n    \n    foreach (string key in queryString.AllKeys)\n    {\n        string value = queryString[key];\n        // Process each key-value pair as needed\n    }\n}