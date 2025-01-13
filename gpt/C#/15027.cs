using System;\nusing System.Net;\nusing System.Net.Sockets;\nusing System.Text;\n\nclass TcpServerExample\n{\n    static void Main()\n    {\n        int port = 500;\n        TcpListener server = new TcpListener(IPAddress.Any, port);\n        server.Start();\n\n        while (true)\n        {\n            TcpClient client = server.AcceptTcpClient();\n            NetworkStream stream = client.GetStream();\n\n            byte[] buffer = new byte[8192]; // 8 KB buffer size\n            int bytesRead;\n            StringBuilder message = new StringBuilder();\n\n            while ((bytesRead = stream.Read(buffer, 0, buffer.Length)) > 0)\n            {\n                message.Append(Encoding.UTF8.GetString(buffer, 0, bytesRead));\n            }\n\n            Console.WriteLine("Received: " + message.ToString());\n\n            stream.Close();\n            client.Close();\n        }\n    }\n}