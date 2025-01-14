Sub Test()\n    Dim dt As New DataTable\n\n    ' Fill datatable code omitted. there are 150 rows in the datatable after this\n\n    ' Convert DataTable to XML string\n    Dim xmlString As String = dt.WriteXmlString()\n\n    ' Create a SqlCommand or use your TableAdapter if properly configured\n    Using connection As New SqlConnection("YourConnectionStringHere")\n        Using command As New SqlCommand("ProcessFile", connection)\n            command.CommandType = CommandType.StoredProcedure\n\n            ' Add the XML parameter\n            command.Parameters.AddWithValue("@x", xmlString)\n\n            ' Open connection and execute command\n            connection.Open()\n            command.ExecuteNonQuery()\n        End Using\n    End Using\nEnd Sub