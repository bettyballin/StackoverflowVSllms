Dim sb As New StringBuilder()\n' Append column headers\nFor Each col As DataColumn In table.Columns\n    sb.Append(col.ColumnName & ",")\nNext\nsb.AppendLine()\n\n' Append rows\nFor Each row As DataRow In table.Rows\n    For Each cell As Object In row.ItemArray\n        sb.Append(cell.ToString() & ",")\n    Next\n    sb.AppendLine()\nNext\n\n' Write CSV file\nFile.WriteAllText("output.csv", sb.ToString())