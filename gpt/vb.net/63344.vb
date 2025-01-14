Dim Bind As New WSHttpBinding(SecurityMode.None, True)\nBind.CloseTimeout = New TimeSpan(0, 1, 0) ' 1 minute\nBind.OpenTimeout = New TimeSpan(0, 1, 0) ' 1 minute\nBind.SendTimeout = New TimeSpan(0, 1, 0) ' 1 minute\n\nTry\n    Dim client As New BN.BNodeServiceClient(Bind, New EndpointAddress("http://localhost:27374/Node"))\n    client.sendMessage("Test Message")\n    client.Close()\n    Console.WriteLine("Message sent successfully.")\nCatch ex As Exception\n    Console.WriteLine("Error: " & ex.Message)\nEnd Try