Dim strSQL As String\nstrSQL = "IF OBJECT_ID('t1', 'U') IS NOT NULL DROP TABLE t1;"\n\ncmd.CommandText = strSQL\ncmd.Execute