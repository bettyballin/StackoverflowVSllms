string encryptedQueryString = Request.QueryString["crypt"];\nif (!string.IsNullOrEmpty(encryptedQueryString))\n{\n    string decryptedQueryString = QueryStringEncryption.Decrypt(encryptedQueryString);\n    // Parse the decrypted query string to get the parameters\n    var queryParameters = HttpUtility.ParseQueryString(decryptedQueryString);\n    string id = queryParameters["id"];\n    string year = queryParameters["year"];\n}