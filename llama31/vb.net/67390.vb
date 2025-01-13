Imports System.Threading\n\nPublic Class DatabaseOperations\n    Private Sub InsertDataIntoMySQLDatabase(data As String)\n        Using connection As New MySqlConnection(mysqlConnString)\n            connection.Open()\n            Dim command As New MySqlCommand("INSERT INTO yourtable (column1) VALUES (@data)", connection)\n            command.Parameters.AddWithValue("@data", data)\n            command.ExecuteNonQuery()\n        End Using\n    End Sub\n\n    Public Sub StartMultithreadedInsert(dataList As List(Of String))\n        For Each data In dataList\n            Dim dataToInsert = data ' Important for closure in multithreading\n            Dim thread As New Thread(Sub() InsertDataIntoMySQLDatabase(dataToInsert))\n            thread.Start()\n        Next\n    End Sub\nEnd Class