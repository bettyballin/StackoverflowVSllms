' Assuming you have a connection named 'conn' and a SQL command setup as follows:\nDim connectionString As String = "YourConnectionString"\nUsing conn As New SqlConnection(connectionString)\n    Dim query As String = "SELECT TOP 10 * FROM YourTable ORDER BY YourColumn" ' Adjust your table and sorting criteria\n    Using cmd As New SqlCommand(query, conn)\n        conn.Open()\n        Using reader As SqlDataReader = cmd.ExecuteReader()\n            While reader.Read()\n                ' Append each record to the RichTextBox. Assuming the first column is what you want to display.\n                richTextBox1.AppendText(reader(0).ToString() & Environment.NewLine)\n            End While\n        End Using\n    End Using\nEnd Using