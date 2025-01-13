private static string GetWebRequestContent(string url)\n{\n    string sid = String.Empty;\n\n    // Set the security protocol to TLS 1.2\n    ServicePointManager.SecurityProtocol = SecurityProtocolType.Tls12;\n\n    // Create the request\n    HttpWebRequest req = (HttpWebRequest)HttpWebRequest.Create(url);\n    req.KeepAlive = false;\n\n    // Specify a modern cipher suite (e.g., AES-256)\n    req.ServicePoint.Expect100Continue = true;\n    req.ServicePoint.DefaultConnectionLimit = 9999;\n    req.ServicePoint.MaxServicePointIdleTime = 99999;\n\n    using (HttpWebResponse res = (HttpWebResponse)req.GetResponse())\n    {\n        using (StreamReader sr = new StreamReader(res.GetResponseStream()))\n        {\n            sid = sr.ReadToEnd().Trim();\n        }\n    }\n\n    return sid;\n}