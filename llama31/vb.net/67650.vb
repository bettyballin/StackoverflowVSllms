Dim sqlconn As SqlConnection\nsqlconn = New SqlConnection("your_connection_string")\n\nDim sqlcmd As SqlCommand\nsqlcmd = New SqlCommand("SELECT Ans FROM Test WHERE User = @auser", sqlconn)\n\nDim par As SqlParameter\npar = New SqlParameter("@auser", SqlDbType.NVarChar)\npar.Value = Textbox1.Text\n\nsqlcmd.Parameters.Add(par)\n\nTry\n    sqlconn.Open()\n    Dim result As String = sqlcmd.ExecuteScalar().ToString()\n    label1.Text = result\nFinally\n    sqlconn.Close()\nEnd Try