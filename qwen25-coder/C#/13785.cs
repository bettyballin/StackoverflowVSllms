try\n{\n    string lcUrl = "https://servicios.mensario.com/enviomasivo/apip/";\n\n    // Set the security protocol to Tls12 which is generally preferred over older versions.\n    System.Net.ServicePointManager.SecurityProtocol = SecurityProtocolType.Tls12;\n\n    // Establish the request\n    HttpWebRequest loHttp = (HttpWebRequest)WebRequest.Create(lcUrl);\n\n    // Set properties\n    loHttp.Timeout = 10000;     // 10 secs\n    loHttp.Method = "POST"; // Use POST as per your requirements\n\n    // Ignore SSL certificate errors only for testing purposes. DO NOT use this in production.\n    System.Net.ServicePointManager.ServerCertificateValidationCallback += delegate { return true; };\n\n    // Retrieve request info headers\n    HttpWebResponse loWebResponse = (HttpWebResponse)loHttp.GetResponse();\n\n    Encoding enc = Encoding.GetEncoding(1252);  // Windows default Code Page\n\n    using (StreamReader loResponseStream = new StreamReader(loWebResponse.GetResponseStream(), enc))\n    {\n        string lcHtml = loResponseStream.ReadToEnd();\n        Console.WriteLine(lcHtml);\n    }\n}\ncatch (WebException ex)\n{\n    if (ex.Status == WebExceptionStatus.ProtocolError)\n    {\n        HttpWebResponse response = ex.Response as HttpWebResponse;\n        if (response != null)\n        {\n            // Process response\n            Console.WriteLine(ex.ToString());\n            using (var reader = new StreamReader(response.GetResponseStream()))\n            {\n                Console.WriteLine(reader.ReadToEnd()); // Output the error body for more details.\n            }\n        }\n    }\n}