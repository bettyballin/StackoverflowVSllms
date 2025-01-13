Imports System.Net\nImports System.Net.Sockets\nImports System.Text\n\nPublic Class Server\n    Private listener As TcpListener\n\n    Public Sub StartServer()\n        Dim localAddr As IPAddress = IPAddress.Parse("127.0.0.1")\n        listener = New TcpListener(localAddr, 5000)\n        listener.Start()\n        Console.WriteLine("Server started...")\n\n        While True\n            Dim client As TcpClient = listener.AcceptTcpClient()\n            Console.WriteLine("Client connected...")\n            Dim thread As New Threading.Thread(AddressOf HandleClient)\n            thread.Start(client)\n        End While\n    End Sub\n\n    Private Sub HandleClient(client As TcpClient)\n        Dim stream As NetworkStream = client.GetStream()\n        Dim bytes(client.ReceiveBufferSize) As Byte\n        Dim data As String\n\n        While True\n            If stream.DataAvailable Then\n                stream.Read(bytes, 0, CInt(client.ReceiveBufferSize))\n                data = Encoding.ASCII.GetString(bytes)\n                Console.WriteLine("Received: " & data)\n                ' Process received data here\n            End If\n        End While\n    End Sub\nEnd Class