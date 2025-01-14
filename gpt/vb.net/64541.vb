Sub LinkOracleTables()\n    Dim db As DAO.Database\n    Dim rs As DAO.Recordset\n    Dim tblName As String\n    Dim connStr As String\n\n    ' Define connection string for Oracle\n    connStr = "ODBC;DSN=YourDSNName;UID=YOUR_USERNAME;PWD=YOUR_PASSWORD;"\n\n    ' Run the pass-through query to get the list of tables\n    Set db = CurrentDb\n    Set rs = db.OpenRecordset("SELECT table_name FROM all_tables WHERE owner = 'YOUR_USERNAME';", dbOpenSnapshot)\n    \n    ' Loop through the recordset and link each table\n    Do While Not rs.EOF\n        tblName = rs!table_name\n        DoCmd.TransferDatabase acLink, "ODBC Database", connStr, acTable, tblName, tblName\n        rs.MoveNext\n    Loop\n    \n    rs.Close\n    Set rs = Nothing\n    Set db = Nothing\nEnd Sub