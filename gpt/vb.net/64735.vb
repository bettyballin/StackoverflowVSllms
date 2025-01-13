Private Sub Form_Load()\n\n    Dim rst As Recordset\n    Dim strSQL As String\n    Dim orderID As Long\n    \n    ' Get the current Order ID from the form\n    orderID = Forms![Order Data Entry Header]![ID]\n    \n    ' Create the SQL string\n    strSQL = "SELECT [ID], [Ln] FROM [Order Detail] WHERE [Order Detail].[ID] = " & orderID\n    \n    ' Open the recordset\n    Set rst = CurrentDb.OpenRecordset(strSQL)\n    \n    ' Move to the last record\n    If Not rst.EOF Then\n        rst.MoveLast\n        ' Set the LineNum field on the form\n        Forms![Order Data Entry Header].LineNum = rst![Ln]\n    End If\n    \n    ' Clean up\n    rst.Close\n    Set rst = Nothing\n\nEnd Sub