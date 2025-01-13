using System;\nusing System.Net.Sockets;\nusing System.Text;\n\nclass TcpClient\n{\n    private TcpClient _client;\n\n    public TcpClient(string hostname, int port)\n    {\n        _client = new TcpClient();\n        _client.Connect(hostname, port);\n    }\n\n    public void SendMessage(string message)\n    {\n        NetworkStream stream = _client.GetStream();\n        byte[] buffer = Encoding.ASCII.GetBytes(message);\n        stream.Write(buffer, 0, buffer.Length);\n    }\n\n    public string ReceiveMessage()\n    {\n        NetworkStream stream = _client.GetStream();\n        byte[] buffer = new byte[1024];\n        int bytesRead = stream.Read(buffer, 0, buffer.Length);\n        return Encoding.ASCII.GetString(buffer, 0, bytesRead);\n    }\n\n    public void Close()\n    {\n        _client.Close();\n    }\n}