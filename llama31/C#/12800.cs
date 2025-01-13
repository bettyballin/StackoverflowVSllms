while (tcpClient.Connected)\n{\n    try\n    {\n        // Read data from the client\n        byte[] buffer = new byte[1024];\n        int bytesRead = tcpClient.GetStream().Read(buffer, 0, buffer.Length);\n        if (bytesRead == 0)\n        {\n            // Client has disconnected\n            break;\n        }\n        // Process the data\n    }\n    catch (IOException)\n    {\n        // Client has disconnected\n        break;\n    }\n}