using System.Net.Sockets;\n\n// ...\n\nSocket socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);\n// ...\n\n// Close the socket connection\nsocket.Close();\n\n// Dispose of the socket object\nsocket.Dispose();