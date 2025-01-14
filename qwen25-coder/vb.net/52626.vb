Imports System.Data.SqlClient\n\n' Assuming you have already created a SqlConnection named 'cn'\nUsing cn As New SqlConnection("your_connection_string")\n    Using cmd As New SqlCommand("sprocUpdate", cn)\n        cmd.CommandType = CommandType.StoredProcedure\n\n        ' Add the parameters for your stored procedure\n        cmd.Parameters.AddWithValue("@ColumnName", ColumnName)\n        cmd.Parameters.AddWithValue("@NewValue", NewValue)\n        cmd.Parameters.AddWithValue("@ID", ID)\n\n        ' Open the connection and execute the command\n        cn.Open()\n        cmd.ExecuteNonQuery()\n\n        ' Optionally, refresh your DataSet if needed\n    End Using\nEnd Using