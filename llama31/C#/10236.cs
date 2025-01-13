using System.Net.Security;\nusing System.Net.Sockets;\n\n// Sender\npublic class Sender\n{\n    public void SendData(byte[] data)\n    {\n        using (var socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))\n        {\n            socket.Connect("receiver-endpoint");\n\n            using (var sslStream = new SslStream(socket))\n            {\n                sslStream.AuthenticateAsClient("receiver-endpoint");\n\n                sslStream.Write(data);\n            }\n        }\n    }\n}\n\n// Receiver\npublic class Receiver\n{\n    public byte[] ReceiveData()\n    {\n        using (var socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp))\n        {\n            socket.Bind(new IPEndPoint(IPAddress.Any, 443));\n            socket.Listen(1);\n\n            using (var sslStream = new SslStream(socket))\n            {\n                sslStream.AuthenticateAsServer("receiver-endpoint");\n\n                byte[] data = new byte[1024];\n                sslStream.Read(data);\n                return data;\n            }\n        }\n    }\n}