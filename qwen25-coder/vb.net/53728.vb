Dim connectionString As String = "Your Oracle connection string"\n   Using con As New OracleConnection(connectionString)\n       Dim cmd As New OracleCommand("SELECT * FROM ChangeHistory", con)\n       con.Open()\n       Using reader As OracleDataReader = cmd.ExecuteReader()\n           While reader.Read()\n               ' Display or use the data as needed\n               Console.WriteLine(reader("TableName") & " - " & reader("Operation"))\n           End While\n       End Using\n   End Using