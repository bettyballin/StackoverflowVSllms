Dim reader As SqlClient.SqlDataReader\nDim valueOrdinal As Integer = reader.GetOrdinal("value")\nIf valueOrdinal <> -1 Then\n    Dim value As String = reader.GetString(valueOrdinal)\n    ' process the value\nElse\n    ' handle the case where the column doesn't exist\nEnd If