CREATE TABLE #TempTable (\n    UserId INT,\n    UserName VARCHAR(50),\n    Email VARCHAR(100),\n    -- ... other columns ...\n);\n\nINSERT INTO #TempTable\nSELECT *\nFROM dbo.aspnet_Users\nWHERE ApplicationId = @ApplicationId AND LoweredUserName LIKE LOWER(@UserNameToMatch);\n\n-- Further processing on #TempTable