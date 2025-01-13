using System;\nusing System.Net.Sockets;\n\nclass Program\n{\n    static void Main()\n    {\n        // Connect to the OpenVPN management interface\n        using (TcpClient client = new TcpClient("localhost", 25340))\n        using (NetworkStream stream = client.GetStream())\n        {\n            byte[] buffer = new byte[1024];\n\n            // Read initial response from OpenVPN\n            int bytesRead = stream.Read(buffer, 0, buffer.Length);\n            Console.WriteLine(Encoding.ASCII.GetString(buffer, 0, bytesRead));\n\n            // Send the 'signal quit' command to shut down OpenVPN\n            string command = "signal quit\n";\n            byte[] dataToSend = Encoding.ASCII.GetBytes(command);\n            stream.Write(dataToSend, 0, dataToSend.Length);\n\n            // Read response from OpenVPN\n            bytesRead = stream.Read(buffer, 0, buffer.Length);\n            Console.WriteLine(Encoding.ASCII.GetString(buffer, 0, bytesRead));\n        }\n    }\n}