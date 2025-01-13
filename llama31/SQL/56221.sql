DECLARE @sql nvarchar(max) = '';\n\nDECLARE cur CURSOR FOR\nSELECT \n    t1.Routine_Name\nFROM\n    [server1].MyDatabase.INFORMATION_SCHEMA.Routines t1 \nLEFT JOIN\n    [server2].MyDatabase.INFORMATION_SCHEMA.Routines t2 ON t1.Routine_Name = t2.Routine_Name\nWHERE\n    t2.Routine_Name is null;\n\nOPEN cur;\n\nFETCH NEXT FROM cur INTO @sql;\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    EXEC [server1].MyDatabase..sp_helptext @sql;\n\n    FETCH NEXT FROM cur INTO @sql;\nEND\n\nCLOSE cur;\nDEALLOCATE cur;