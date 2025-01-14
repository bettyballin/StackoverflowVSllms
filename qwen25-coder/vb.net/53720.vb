Dim connetionString As String = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=|DataDirectory|\prod.mdb"\nDim sql As String = "SELECT * FROM table1 WHERE prodid=@prodid"\n\nUsing cnn As New OleDb.OleDbConnection(connetionString)\n    Using cmd As New OleDb.OleDbCommand(sql, cnn)\n        cmd.Parameters.AddWithValue("@prodid", searchfield.Text)\n        Try\n            cnn.Open()\n            Dim reader As OleDb.OleDbDataReader = cmd.ExecuteReader()\n            If reader.HasRows Then\n                While reader.Read()\n                    Text = reader(0).ToString()\n                End While\n            Else\n                Text = "No rows found."\n            End If\n        Catch ex As Exception\n            Text = "Error: " & ex.Message\n        Finally\n            cnn.Close()\n        End Try\n    End Using\nEnd Using