Private Sub QResultButton_Click()\n    Dim strSQL As String\n    strSQL = "INSERT INTO TableName (id, othercolumn, another) " & _\n             "SELECT id, othercolumn, another FROM Readings2009 " & _\n             "WHERE something > Date()"\n    DoCmd.RunSQL strSQL\nEnd Sub