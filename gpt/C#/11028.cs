using System;\nusing System.Net;\nusing System.Net.Sockets;\nusing System.Text;\n\nclass Program\n{\n    static void Main()\n    {\n        UdpClient udpClient = new UdpClient(12345);\n        IPEndPoint remoteEndPoint = new IPEndPoint(IPAddress.Any, 12345);\n\n        Console.WriteLine("Listening for UDP packets...");\n        while (true)\n        {\n            byte[] data = udpClient.Receive(ref remoteEndPoint);\n            string message = Encoding.ASCII.GetString(data);\n            Console.WriteLine($"Received: {message}");\n        }\n    }\n}