Private ConnectionString As String = "Provider=OraOLEDB.Oracle;Data Source=(DESCRIPTION=(CID=GTU_APP)(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=xxx)(PORT=xxx)))(CONNECT_DATA=(SID=xxx)(SERVER=DEDICATED)));User Id=xxx;Password=xxx;"\nPrivate SQL As String = "INSERT INTO XXX.BU_LOG (PROGRAM, LOCATION, MESSAGE, TIMESTAMP, ""LEVEL"", COMPUTER, ""USER"") VALUES (@Program, @Location, @Message, @Timestamp, @LevelName, @Computer, @UserName)"\n\nPublic Sub Write(ByVal Program As String, ByVal Location As String, ByVal Message As String, Optional ByVal Timestamp As DateTime?, Optional ByVal LevelName As String = "INFO", Optional ByVal Computer As String = "", Optional ByVal User As String = "")\n    Using Connection As New OleDbConnection(ConnectionString)\n        Dim Command As New OleDbCommand(SQL, Connection)\n\n        ' Add parameters to prevent SQL injection and ensure correct data types\n        Command.Parameters.AddWithValue("@Program", Program)\n        Command.Parameters.AddWithValue("@Location", Location)\n        Command.Parameters.AddWithValue("@Message", Message)\n        Command.Parameters.AddWithValue("@Timestamp", If(Timestamp.HasValue, Timestamp.Value, DateTime.Now))\n        Command.Parameters.AddWithValue("@LevelName", LevelName)\n        Command.Parameters.AddWithValue("@Computer", Computer)\n        Command.Parameters.AddWithValue("@UserName", User)\n\n        Connection.Open()\n        Command.ExecuteNonQuery()\n    End Using\nEnd Sub