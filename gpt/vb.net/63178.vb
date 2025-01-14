Imports System.Net\nImports System.Net.Sockets\nImports System.Text\nImports System.Threading\n\nPublic Class UdpBroadcast\n    Private rClient As UdpClient\n    Private ThreadReceive As Thread\n    Private broadcastip As IPAddress\n    Private iep As IPEndPoint\n    Private port As Integer = 12345 ' Make sure this is the same for sender and receiver\n    Private hostname As String\n    Private myip As IPAddress\n    Private ipsplit As String()\n\n    Private Sub connect()\n        setip()\n        btnsend.Enabled = True\n        btndisconnect.Enabled = True\n        btnconnect.Enabled = False\n        receive()\n        txtmsg.Enabled = True\n    End Sub\n\n    Sub receive()\n        Try\n            rClient = New UdpClient(port)\n            rClient.EnableBroadcast = True\n            ThreadReceive = New Thread(AddressOf receivemessages)\n            ThreadReceive.IsBackground = True\n            ThreadReceive.Start()\n        Catch ex As Exception\n            MsgBox("Error: " & ex.Message)\n        End Try\n    End Sub\n\n    Sub receivemessages()\n        Try\n            While True\n                Dim rip As IPEndPoint = New IPEndPoint(IPAddress.Any, port)\n                Dim receiveBytes As Byte() = rClient.Receive(rip)\n                Dim strReturnData As String = Encoding.ASCII.GetString(receiveBytes)\n                Invoke(Sub() MsgBox("Received: " & strReturnData))\n            End While\n        Catch ex As Exception\n            ' Handle exceptions, possibly log them\n        End Try\n    End Sub\n\n    Private Sub setip()\n        hostname = Dns.GetHostName()\n        myip = IPAddress.Parse(Dns.GetHostEntry(hostname).AddressList(1).ToString())\n        ipsplit = myip.ToString().Split("."c)\n        ipsplit(3) = "255"\n        broadcastip = IPAddress.Parse(String.Join(".", ipsplit))\n        iep = New IPEndPoint(broadcastip, port)\n    End Sub\n\n    Sub sendmsg()\n        Try\n            Dim msg As Byte() = Encoding.ASCII.GetBytes(txtmsg.Text)\n            Using sclient As New UdpClient()\n                sclient.EnableBroadcast = True\n                sclient.Send(msg, msg.Length, iep)\n            End Using\n            txtmsg.Clear()\n        Catch ex As Exception\n            MsgBox("Error: " & ex.Message)\n        End Try\n    End Sub\nEnd Class