TcpListener pServer = new TcpListener(localIP, port);\npServer.Start(256);\nSocket a_socket = pServer.AcceptSocket();\n\nbyte[] buffer = new byte[3];\nint bytesRead = a_socket.Receive(buffer, 0, 3, SocketFlags.Peek);\n\nbool isSsl = false;\n\nif (bytesRead == 3)\n{\n    // Check if the first byte is 0x16 and the next two bytes represent a valid SSL/TLS version\n    if (buffer[0] == 0x16 && buffer[1] == 0x03 && (buffer[2] == 0x00 || buffer[2] == 0x01 || buffer[2] == 0x02 || buffer[2] == 0x03))\n    {\n        isSsl = true;\n    }\n}\n\nNetworkStream networkStream = new NetworkStream(a_socket);\n\nif (isSsl)\n{\n    SslStream sslStream = new SslStream(networkStream, false);\n    // Proceed with SSL handshake\n    sslStream.AuthenticateAsServer(serverCertificate, false, SslProtocols.Tls12, true);\n    // Use sslStream for further communication\n}\nelse\n{\n    // Use networkStream for further communication\n}