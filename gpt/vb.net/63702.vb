Private Sub readusersdata(ByVal userdatafile As String)\n    ListView1.BeginUpdate()\n    ListView1.Items.Clear()\n    \n    Using fs As New IO.FileStream(userdatafile, IO.FileMode.Open, IO.FileAccess.Read)\n        fs.Position = 4\n        Dim usersm As Integer = fs.ReadByte()\n        Dim users As Integer = usersm\n        \n        While users > 0\n            If usersm = users Then\n                fs.Position = 6\n                Dim ust As Integer = fs.ReadByte()\n                fs.Position = 8\n                Dim snb(ust - 1) As Byte\n                fs.Read(snb, 0, ust)\n                Dim bst = System.Text.Encoding.Default.GetString(snb)\n                \n                If usersm = 1 Then\n                    fs.Position = 16\n                Else\n                    fs.Position = 15\n                End If\n                \n                cLVN(ListView1, bst, fs.ReadByte())\n                fs.Position = 8 + snb.Length\n                fs.Position += fs.ReadByte() + 1\n            Else\n                Dim usn As Integer = fs.ReadByte()\n                fs.Position += 2\n                Dim chrpos As Integer = fs.Position\n                Dim xnl(usn - 1) As Byte\n                fs.Read(xnl, 0, usn - 1)\n                Dim skpbyte As Integer = fs.ReadByte()\n                fs.Position += 3\n                Dim udata As Integer = fs.ReadByte()\n            End If\n            \n            users -= 1\n        End While\n    End Using\n    \n    ListView1.EndUpdate()\nEnd Sub