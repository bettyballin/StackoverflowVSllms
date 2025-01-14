Dim ds As New DataSet("MyTable")\n' Assuming you have some way to fill the dataset, e.g., using an adapter or similar.\n' dsDataAdapter.Fill(ds)\n\nIf ds.Tables.Count > 0 AndAlso ds.Tables(0).Rows.Count > 0 Then\n    Dim dataRowView As DataRowView = CType(New DataView(ds.Tables(0))(0), DataRowView)\n    If Not IsDBNull(dataRowView("ID_Equipamento")) AndAlso Not IsDBNull(dataRowView("ID_Password")) Then\n        Dim ID_Equipamento As String = dataRowView("ID_Equipamento").ToString()\n        Dim ID_Password As String = dataRowView("ID_Password").ToString()\n        \n        ' Use the variables as needed\n    Else\n        Console.WriteLine("One or more columns contain DBNull.")\n    End If\nElse\n    Console.WriteLine("No data found in the dataset.")\nEnd If