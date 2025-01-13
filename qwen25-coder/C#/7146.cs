protected void btnUpload_Click(object sender, EventArgs e)\n{\n    if (filMyFile.HasFile)\n    {\n        string fileName = Path.GetFileName(filMyFile.FileName);\n        byte[] fileBytes;\n\n        using (BinaryReader br = new BinaryReader(filMyFile.PostedFile.InputStream))\n        {\n            fileBytes = br.ReadBytes(filMyFile.PostedFile.ContentLength);\n        }\n\n        // Proxy the file upload to Server B\n        UploadFileToServerB(fileName, fileBytes);\n\n        // Optionally, delete the temporary storage here if needed\n    }\n}\n\nprivate void UploadFileToServerB(string fileName, byte[] fileBytes)\n{\n    string url = "https://serverb.com/upload";\n    HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);\n    request.Method = "POST";\n    request.ContentType = "multipart/form-data";\n\n    // Create a boundary for separation of files in multipart form data\n    string boundary = "---------------------------" + DateTime.Now.Ticks.ToString("x");\n    request.Headers.Add(HttpRequestHeader.ContentType, "multipart/form-data; boundary=" + boundary);\n\n    using (Stream requestStream = request.GetRequestStream())\n    {\n        StringBuilder requestDataBuilder = new StringBuilder();\n        requestDataBuilder.AppendFormat("--{0}\r\n", boundary);\n        requestDataBuilder.AppendFormat("Content-Disposition: form-data; name=\"file\"; filename=\"{0}\"\r\n", fileName);\n        requestDataBuilder.AppendFormat("Content-Type: {0}\r\n\r\n", "application/octet-stream");\n\n        byte[] requestDataBytes = System.Text.Encoding.UTF8.GetBytes(requestDataBuilder.ToString());\n        requestStream.Write(requestDataBytes, 0, requestDataBytes.Length);\n\n        requestStream.Write(fileBytes, 0, fileBytes.Length);\n        byte[] trailer = System.Text.Encoding.ASCII.GetBytes("\r\n--" + boundary + "--\r\n");\n        requestStream.Write(trailer, 0, trailer.Length);\n    }\n\n    HttpWebResponse response = (HttpWebResponse)request.GetResponse();\n    using (StreamReader reader = new StreamReader(response.GetResponseStream()))\n    {\n        string result = reader.ReadToEnd();\n        // Handle the response from Server B here if needed\n    }\n}