Imports System.Data.OleDb\n\nDim connectionString As String = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=C:\Path\To\Your\AccessDB.accdb"\nDim connection As New OleDbConnection(connectionString)\n\nconnection.Open()\n\nDim command As New OleDbCommand("SELECT * FROM MSysProperties WHERE Container = 'Database'", connection)\nDim reader As OleDbDataReader = command.ExecuteReader()\n\nWhile reader.Read()\n    Console.WriteLine(reader("Name").ToString() & ": " & reader("Value").ToString())\nEnd While\n\nreader.Close()\nconnection.Close()