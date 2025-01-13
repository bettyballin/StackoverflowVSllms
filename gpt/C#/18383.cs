public class SslTcpClient\n{\n    private static void RunClient(string server, int port)\n    {\n        try\n        {\n            // Create a TCP/IP client socket.\n            TcpClient client = new TcpClient(server, port);\n            Console.WriteLine("Client connected.");\n\n            // Create an SSL stream that will close the client's stream.\n            SslStream sslStream = new SslStream(client.GetStream(), false,\n                new RemoteCertificateValidationCallback(ValidateServerCertificate), null);\n\n            // The server name must match the name on the server certificate.\n            try\n            {\n                sslStream.AuthenticateAsClient(server);\n            }\n            catch (AuthenticationException e)\n            {\n                Console.WriteLine("Exception: {0}", e.Message);\n                if (e.InnerException != null)\n                {\n                    Console.WriteLine("Inner exception: {0}", e.InnerException.Message);\n                }\n                Console.WriteLine("Authentication failed - closing the connection.");\n                client.Close();\n                return;\n            }\n\n            // Encode a test message into a byte array.\n            byte[] message = System.Text.Encoding.UTF8.GetBytes("Hello from the client.<EOF>");\n            // Send the message to the server.\n            sslStream.Write(message);\n            sslStream.Flush();\n\n            // Read message from the server.\n            string serverMessage = ReadMessage(sslStream);\n            Console.WriteLine("Server says: {0}", serverMessage);\n\n            // Close the client connection.\n            client.Close();\n            Console.WriteLine("Client closed.");\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Exception: {0}", ex.Message);\n        }\n    }\n\n    private static string ReadMessage(SslStream sslStream)\n    {\n        // Read the 4 bytes indicating the size of the message.\n        byte[] buffer = new byte[2048];\n        int bytes = -1;\n        MemoryStream memoryStream = new MemoryStream();\n        do\n        {\n            bytes = sslStream.Read(buffer, 0, buffer.Length);\n            memoryStream.Write(buffer, 0, bytes);\n        } while (bytes != 0);\n\n        return System.Text.Encoding.UTF8.GetString(memoryStream.ToArray());\n    }\n\n    // The following method is invoked by the RemoteCertificateValidationDelegate.\n    public static bool ValidateServerCertificate(\n          object sender,\n          X509Certificate certificate,\n          X509Chain chain,\n          SslPolicyErrors sslPolicyErrors)\n    {\n        if (sslPolicyErrors == SslPolicyErrors.None)\n            return true;\n\n        Console.WriteLine("Certificate error: {0}", sslPolicyErrors);\n\n        // Do not allow this client to communicate with unauthenticated servers.\n        return false;\n    }\n\n    public static void Main(string[] args)\n    {\n        // Specify the server name and port.\n        string server = "your_server_name";\n        int port = 110; // Replace with your actual port number\n        RunClient(server, port);\n    }\n}