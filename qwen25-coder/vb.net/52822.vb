Public Shared Function doesBasketExist(ByVal baskethash As String) As Boolean\n    Dim _r As Boolean = False ' Initialize with default value\n    Using db As New SqlConnection(System.Configuration.ConfigurationManager.ConnectionStrings("pitstopConnectionString").ConnectionString)\n        db.Open() ' Open the connection here\n        Using cmd As New SqlCommand("doGetBasketByHash", db)\n            cmd.CommandType = CommandType.StoredProcedure\n            cmd.Parameters.AddWithValue("@baskethash", baskethash)\n            Using dr As SqlDataReader = cmd.ExecuteReader()\n                _r = dr.HasRows ' No need for explicit if-else\n            End Using\n        End Using\n    End Using\n    Return _r\nEnd Functio