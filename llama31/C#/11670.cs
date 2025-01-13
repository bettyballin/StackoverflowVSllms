using System;\nusing System.Net;\nusing System.Net.Sockets;\n\nclass UdpReceiver\n{\n    private UdpClient _udpClient;\n\n    public UdpReceiver(int port)\n    {\n        _udpClient = new UdpClient(port);\n    }\n\n    public void Start()\n    {\n        while (true)\n        {\n            IPEndPoint remoteEndPoint = null;\n            byte[] data = _udpClient.Receive(ref remoteEndPoint);\n            string message = Encoding.ASCII.GetString(data);\n            Console.WriteLine(message);\n        }\n    }\n}