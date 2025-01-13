Sub ExportQueryToCSV()\n    Dim db As DAO.Database\n    Dim qdf As DAO.QueryDef\n    Dim rst As DAO.Recordset\n    Dim filepath As String\n\n    ' Set the file path for the CSV file\n    filepath = "C:\Path\To\Your\File\output.csv"\n    \n    ' Open the database\n    Set db = CurrentDb()\n    \n    ' Open the query\n    Set qdf = db.QueryDefs("YourQueryName")\n    \n    ' Open the recordset\n    Set rst = qdf.OpenRecordset()\n    \n    ' Open the CSV file for output\n    Open filepath For Output As #1\n    \n    ' Write the column headers\n    For i = 0 To rst.Fields.Count - 1\n        Print #1, rst.Fields(i).Name & IIf(i < rst.Fields.Count - 1, vbTab, "")\n    Next i\n    \n    ' Write the data\n    Do While Not rst.EOF\n        For i = 0 To rst.Fields.Count - 1\n            Print #1, rst.Fields(i).Value & IIf(i < rst.Fields.Count - 1, vbTab, "")\n        Next i\n        Print #1, ""\n        rst.MoveNext\n    Loop\n    \n    ' Close the file\n    Close #1\n    \n    ' Clean up\n    rst.Close\n    Set rst = Nothing\n    Set qdf = Nothing\n    Set db = Nothing\nEnd Sub