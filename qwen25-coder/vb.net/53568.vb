Sub UpdateDatabase()\n    Dim conn As Object\n    Dim sqlQuery As String\n    \n    ' Create the connection object\n    Set conn = CreateObject("ADODB.Connection")\n    \n    ' Open the connection with your connection string (adjust the parameters accordingly)\n    conn.Open "Driver={SQL Server};Server=your_server_name;Database=Your_DB_Name;Trusted_Connection=yes;"\n    \n    ' Define SQL query to update data. Adjust accordingly.\n    sqlQuery = "UPDATE Your_Table SET Column1 = '" & Cells(2, 1).Value & "' WHERE ID = " & Cells(2, 2).Value\n    \n    ' Execute the SQL command\n    conn.Execute sqlQuery\n    \n    ' Close connection and clean up\n    conn.Close\n    Set conn = Nothing\nEnd Sub