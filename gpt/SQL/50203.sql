SELECT \n    ApplicationName, \n    MethodName, \n    AVG(TimeInMs) AS AvgTimeInMs\nFROM \n    YourTableName\nWHERE \n    DateTime >= DATEADD(MINUTE, -1, GETDATE()) -- Change MINUTE to HOUR, DAY, WEEK, MONTH as needed\nGROUP BY \n    ApplicationName, \n    MethodName;