Private ConnectionString As String = "Provider=OraOLEDB.Oracle;Data Source=(DESCRIPTION=(CID=GTU_APP)(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=xxx)(PORT=xxx)))(CONNECT_DATA=(SID=xxx)(SERVER=DEDICATED)));User Id=xxx;Password=xxx;"\n\nPrivate Sub InsertLog(Program As String, Location As String, Message As String, Timestamp As String, LevelName As String, Computer As String, User As String)\n    Dim SQL As String = "INSERT INTO XXX.BU_LOG (PROGRAM, LOCATION, MESSAGE, TIMESTAMP, ""LEVEL"", COMPUTER, ""USER"") VALUES (?, ?, ?, ?, ?, ?, ?)"\n    \n    Using Connection As New OleDbConnection(ConnectionString)\n        Using Command As New OleDbCommand(SQL, Connection)\n            Command.Parameters.AddWithValue("?", Program)\n            Command.Parameters.AddWithValue("?", Location)\n            Command.Parameters.AddWithValue("?", Message)\n            Command.Parameters.AddWithValue("?", Timestamp)\n            Command.Parameters.AddWithValue("?", LevelName)\n            Command.Parameters.AddWithValue("?", Computer)\n            Command.Parameters.AddWithValue("?", User)\n            \n            Connection.Open()\n            Command.ExecuteNonQuery()\n        End Using\n    End Using\nEnd Sub\n\n' Usage example\nlog.InsertLog(My.Application.Info.AssemblyName, System.Reflection.MethodBase.GetCurrentMethod.Name, "Hello World!", "timestamp_value", "level_value", "computer_name", "user_name")\nlog.InsertLog(My.Application.Info.AssemblyName, System.Reflection.MethodBase.GetCurrentMethod.Name, "Testing", "timestamp_value", "level_value", "computer_name", "user_name")