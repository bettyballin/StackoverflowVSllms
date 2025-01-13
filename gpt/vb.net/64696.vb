Private Sub btnSubmit_Click()\n\n    Dim db As DAO.Database\n    Dim rs As DAO.Recordset\n    Dim strSQL As String\n    Dim strSurname As String\n    \n    ' Get the surname from the textbox\n    strSurname = Me.txtSurname.Value\n    \n    ' Construct the SQL query\n    strSQL = "SELECT [count] FROM [table] WHERE [surname] = '" & strSurname & "'"\n    \n    ' Open the database and the recordset\n    Set db = CurrentDb\n    Set rs = db.OpenRecordset(strSQL)\n    \n    ' Check if the recordset has any records\n    If Not rs.EOF Then\n        ' Retrieve the count value\n        Me.lblCount.Caption = rs!count\n    Else\n        ' Display a message if the surname is not found\n        Me.lblCount.Caption = "Surname not found"\n    End If\n    \n    ' Close the recordset and the database\n    rs.Close\n    Set rs = Nothing\n    Set db = Nothing\n\nEnd Sub