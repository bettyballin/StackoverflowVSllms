protected void bText_Click(object sender, EventArgs e)\n{\n    string XML = "<?xml version=\"1.0\"?>" +\n                "<methodCall>" +\n                "<methodName>send</methodName>" +\n                "    <params>" +\n                "        <param>" +\n                "            <value><string>MY KEY</string></value>" +\n                "        </param>" +\n                "        <param>" +\n                "            <value><string>service@example.com</string></value>" +\n                "       </param>" +\n                "       <param>" +\n                "           <value><string>555555555</string></value>" +\n                "       </param>" +\n                "       <param>" +\n                "          <value><string>Test Message</string></value>" +\n                "      </param>" +\n                "  </params>" +\n                "</methodCall>";\n\n    SendText("https://api.pennysms.com/xmlrpc", XML);\n}\n\npublic void SendText(string _URL, string _parameters)\n{\n    WebRequest request = WebRequest.Create(_URL);\n    request.Method = "POST";\n    byte[] byteArray = Encoding.UTF8.GetBytes(_parameters);\n\n    // Set the ContentType property of the WebRequest.\n    request.ContentType = "text/xml";\n\n    // Set the ContentLength property of the WebRequest.\n    request.ContentLength = byteArray.Length;\n\n    using (Stream stream = request.GetRequestStream())\n    {\n        stream.Write(byteArray, 0, byteArray.Length);\n    }\n\n    try\n    {\n        using (WebResponse response = request.GetResponse())\n        {\n            using (StreamReader reader = new StreamReader(response.GetResponseStream()))\n            {\n                string responseFromServer = reader.ReadToEnd();\n                // Do something with the response from the server.\n                Console.WriteLine(responseFromServer);\n            }\n        }\n    }\n    catch (WebException ex)\n    {\n        // Log or handle any errors here\n        Console.WriteLine("Error: " + ex.Message);\n    }\n}