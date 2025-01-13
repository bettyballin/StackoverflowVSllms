Using cn = New OleDbConnection(connectionstring)\n    cn.Open()\n    Dim ds As DataSet = new DataSet()\n\n    Dim Schema As DataTable = cn.GetOleDbSchemaTable(OleDbSchemaGuid.Tables, New Object() {Nothing, Nothing, Nothing, "TABLE"})\n    For i As Integer = 0 To Schema.Rows.Count - 1\n        Dim dt As DataTable = New DataTable(Schema.Rows(i)!TABLE_NAME.ToString())\n\n        Using adapter = New OleDbDataAdapter("SELECT * FROM " + Schema.Rows(i)!TABLE_NAME.ToString(), cn)\n            adapter.Fill(dt)\n        End Using\n\n        ds.Tables.Add(dt)\n    Next i\nEnd Using