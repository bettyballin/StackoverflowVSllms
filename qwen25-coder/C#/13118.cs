using System;\nusing System.Net.Sockets;\nusing System.Text;\n\npublic class ChatClient {\n    static void Main(string[] args) {\n        TcpClient client = new TcpClient();\n        \n        try {\n            // Connect to the server on local machine at port 12345\n            client.Connect("127.0.0.1", 12345);\n            \n            NetworkStream stream = client.GetStream();\n            \n            byte[] buffer = new byte[256];\n            int bytesRead = stream.Read(buffer, 0, buffer.Length);\n            string messageReceived = Encoding.ASCII.GetString(buffer, 0, bytesRead);      \n            \n            Console.WriteLine("Server: " + messageReceived);\n        } catch (Exception e) {\n            Console.WriteLine(e.Message);\n        } finally {\n            client.Close();\n        }\n    }\n}