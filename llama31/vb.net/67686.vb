Dim adapter As New Table1TableAdapter()\nadapter.DataProvider = "SQLCompact"\nadapter.SelectCommand.CommandText = "SELECT ... FROM Table1 ... INNER JOIN ... "