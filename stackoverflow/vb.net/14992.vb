Dim dbs As Database\nDim rs As Recordset\nDim strSQL As String\nSet dbs = CurrentDb\n\nstrSQL = 'your query here\n\nSet rs = dbs.OpenRecordset(strSQL)\n\nIf Not (rs.EOF And rs.BOF) Then\n  rs.MoveFirst\n  'get results using rs.Fields()\nElse\n\n'Use results