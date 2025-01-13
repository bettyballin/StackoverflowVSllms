using System;\nusing System.IO;\nusing System.Net.Security;\nusing System.Net.Sockets;\nusing System.Security.Authentication;\n\nclass NegotiateHelper\n{\n    private NetworkStream _stream;\n    private NegotiateStream _negotiateStream;\n\n    public void StartNegotiation(NetworkStream stream)\n    {\n        _stream = stream;\n        _negotiateStream = new NegotiateStream(_stream, false);\n        \n        // Asynchronous begin authentication negotiation as a server\n        _negotiateStream.BeginAuthenticateAsServer(\n            (IAsyncResult asyncResult) =>\n                EndAuthentication(asyncResult),\n            null);\n    }\n\n    private void EndAuthentication(IAsyncResult result)\n    {\n        try\n        {\n            // Complete the asynchronous operation.\n            _negotiateStream.EndAuthenticateAsServer(result);\n\n            Console.WriteLine("Authentication complete.");\n            \n            // Now you can read/write to the NegotiateStream\n        }\n        catch (Exception e)\n        {\n            Console.WriteLine("Authentication failed: " + e.Message);\n        }\n    }\n\n    public void WriteData(string data)\n    {\n        byte[] buffer = System.Text.Encoding.UTF8.GetBytes(data);\n        _negotiateStream.Write(buffer, 0, buffer.Length);\n    }\n\n    public string ReadData()\n    {\n        byte[] buffer = new byte[1024];\n        int bytesRead = _negotiateStream.Read(buffer, 0, buffer.Length);\n        return System.Text.Encoding.UTF8.GetString(buffer, 0, bytesRead);\n    }\n}