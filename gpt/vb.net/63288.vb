Dim pathString As String = HttpContext.Current.Request.MapPath("Banking.mdb")\nDim odbconBanking As New OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=" & pathString)\nDim sql As String = "INSERT INTO tblUsers (FirstName, LastName, Address, City, Province, Zip, Phone, UserName, [Password])" & _\n                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);"\nDim sqlGetId As String = "SELECT @@IDENTITY;"\n\nTry\n    odbconBanking.Open()\n    \n    ' Use parameterized command to prevent SQL injection\n    Dim cmd As New OleDbCommand(sql, odbconBanking)\n    cmd.Parameters.AddWithValue("?", firstName)\n    cmd.Parameters.AddWithValue("?", lastName)\n    cmd.Parameters.AddWithValue("?", address)\n    cmd.Parameters.AddWithValue("?", city)\n    cmd.Parameters.AddWithValue("?", province)\n    cmd.Parameters.AddWithValue("?", zip)\n    cmd.Parameters.AddWithValue("?", phone)\n    cmd.Parameters.AddWithValue("?", username)\n    cmd.Parameters.AddWithValue("?", password)\n    \n    cmd.ExecuteNonQuery()\n    \n    ' Get the last inserted ID\n    cmd.CommandText = sqlGetId\n    Dim userID As Integer = Convert.ToInt32(cmd.ExecuteScalar())\n    \n    ' Output the UserID or use it as needed\n    Response.Write("Inserted UserID: " & userID)\n\nFinally\n    odbconBanking.Close()\nEnd Try