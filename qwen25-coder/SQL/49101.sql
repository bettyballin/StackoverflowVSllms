DECLARE @ProcedureName NVARCHAR(500)\nDECLARE @Path nvarchar(1000) = 'C:\PATH_TO_SAVE\'  -- Change this path accordingly\nDECLARE @FileName NVARCHAR(500)\n\n-- Cursor to fetch all procedure names from the database\nDECLARE ProceduresCursor CURSOR FOR \nSELECT name FROM sys.objects WHERE type = 'P'\n\nOPEN ProceduresCursor\n\nFETCH NEXT FROM ProceduresCursor INTO @ProcedureName\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    SET @FileName = QUOTENAME(REPLACE(@ProcedureName, '''', ''), '"') + '.sql'\n    \n    -- Command to write the script of procedure into a file\n    EXEC('sp_configure ''advanced options'',1;reconfigure;')\n    EXEC('sp_configure ''xp_cmdshell'',1;reconfigure;')\n\n    -- Note: sp_helptext is not suitable for very large procedures. For larger ones, you might need to loop through sys.sql_modules or similar.\n    EXECUTE xp_cmdshell\n        'osql -E -S YourServerName -d YourDatabaseName -Q "sp_helptext [' + @ProcedureName + ']'\n        + '" -o "' + @Path + '' + @FileName + '"''\n\n    FETCH NEXT FROM ProceduresCursor INTO @ProcedureName\nEND\n\nCLOSE ProceduresCursor\nDEALLOCATE ProceduresCursor\n\n-- Revert configurations if you don't want them permanently changed\nEXEC('sp_configure ''advanced options'',0;reconfigure;')\nEXEC('sp_configure ''xp_cmdshell'',0;reconfigure;')