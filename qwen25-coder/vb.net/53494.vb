Imports System.Net.Sockets\nImports System.Text\n\nModule Module1\n    Sub Main()\n        Dim listener As New TcpListener(5000)\n        listener.Start()\n        Console.WriteLine("Waiting for connection...")\n        Dim client As TcpClient = listener.AcceptTcpClient()\n        Console.WriteLine("Connected!")\n        Dim data As String = Nothing\n        ' Get a stream object for reading and writing\n        Dim networkStream As NetworkStream = client.GetStream()\n        Dim bytes(1024) As Byte\n\n        Do While (True)\n            Dim numberOfBytesRead As Integer = _\n                networkStream.Read(bytes, 0, CInt(bytes.Length))\n            data = Encoding.ASCII.GetString(bytes, 0, numberOfBytesRead)\n            Console.WriteLine("Received: {0}", data)\n\n            ' Process the data sent by the client.\n            Dim responseString As String = "Echo: " + data & "<EOF>"\n            Dim sendBytes As Byte() = _\n                Encoding.ASCII.GetBytes(responseString)\n            networkStream.Write(sendBytes, 0, sendBytes.Length)\n            Console.WriteLine("Sent: {0}", responseString)\n\n        Loop\n\n        ' Shutdown and end connection\n        client.Close()\n    End Sub\nEnd Module