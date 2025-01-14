Sub ImportDataWithLineBreaks()\n    Dim conn As Object\n    Dim rs As Object\n    Dim sql As String\n    Dim connectionString As String\n    \n    ' Define your connection string\n    connectionString = "Provider=SQLOLEDB;Data Source=YourServerName;" & _\n                           "Initial Catalog=YourDatabaseName;Integrated Security=SSPI;"\n    \n    ' Create a new connection and recordset object\n    Set conn = CreateObject("ADODB.Connection")\n    Set rs = CreateObject("ADODB.Recordset")\n    \n    ' Define your SQL query\n    sql = "SELECT * FROM YourTableName"\n    \n    ' Open the connection and execute the query\n    conn.Open connectionString\n    rs.Open sql, conn\n    \n    ' Check if there are records\n    If Not rs.EOF Then\n        ' Copy data to Excel while preserving line breaks\n        Sheet1.Range("A1").CopyFromRecordset rs\n        \n        ' Convert CHAR(10) and CHAR(13) to Alt+Enter in the cells\n        Dim cell As Range\n        For Each cell In Sheet1.UsedRange\n            If cell.Value <> "" Then\n                cell.Value = Replace(cell.Value, vbCr, "")\n                cell.Value = Replace(cell.Value, vbLf, vbCrLf)\n                cell.WrapText = True\n            End If\n        Next cell\n    Else\n        MsgBox "No data found!"\n    End If\n    \n    ' Clean up\n    rs.Close\n    conn.Close\n    Set rs = Nothing\n    Set conn = Nothing\nEnd Sub