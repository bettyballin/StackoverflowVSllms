private string GetJsonResponse(string command, Dictionary<string, string> parameters)\n{\n    string requestUri = BuildRequestUri(command, parameters);\n\n    HttpWebRequest webRequest = (HttpWebRequest)HttpWebRequest.Create(requestUri);\n    webRequest.AllowWriteStreamBuffering = true;\n\n    // Add this line to bypass certificate validation\n    webRequest.ServerCertificateValidationCallback = new RemoteCertificateValidationCallback(ValidateServerCertificate);\n\n    cookieManager.PublishCookies(webRequest);\n    HttpWebResponse webResponse = (HttpWebResponse)webRequest.GetResponse();\n\n    string jsonResponse = string.Empty;\n\n    using (StreamReader streamReader = new StreamReader(webResponse.GetResponseStream()))\n    {\n        jsonResponse = streamReader.ReadToEnd();\n    }\n\n    webResponse.Close();\n\n    return jsonResponse;\n}\n\nprivate bool ValidateServerCertificate(object sender, X509Certificate certificate, X509Chain chain, SslPolicyErrors sslPolicyErrors)\n{\n    // You can add your own validation logic here\n    // For now, just return true to bypass validation\n    return true;\n}