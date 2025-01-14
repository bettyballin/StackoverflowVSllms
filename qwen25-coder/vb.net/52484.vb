Dim pathString As String = HttpContext.Current.Request.MapPath("Banking.mdb")\nUsing odbconBanking As New OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=" & pathString)\n    Dim sql As String = "INSERT INTO tblUsers (FirstName, LastName, Address, City, Province, Zip, Phone, UserName, [Password]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"\n    odbconBanking.Open()\n    \n    Using cmd As New OleDbCommand(sql, odbconBanking)\n        ' Use parameters to prevent SQL injection\n        cmd.Parameters.AddWithValue("@FirstName", firstName)\n        cmd.Parameters.AddWithValue("@LastName", lastName)\n        cmd.Parameters.AddWithValue("@Address", address)\n        cmd.Parameters.AddWithValue("@City", city)\n        cmd.Parameters.AddWithValue("@Province", province)\n        cmd.Parameters.AddWithValue("@Zip", zip)\n        cmd.Parameters.AddWithValue("@Phone", phone)\n        cmd.Parameters.AddWithValue("@UserName", username)\n        cmd.Parameters.AddWithValue("@Password", password)\n        \n        cmd.ExecuteNonQuery()\n        \n        ' Retrieve the last inserted ID\n        Dim sqlGetIdentity As String = "SELECT @@IDENTITY"\n        Using cmdIdentity As New OleDbCommand(sqlGetIdentity, odbconBanking)\n            Dim lastId As Integer = Convert.ToInt32(cmdIdentity.ExecuteScalar())\n            Response.Write("Last Inserted UserID: " & lastId.ToString())\n        End Using\n    End Using\nEnd Using