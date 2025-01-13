ALTER PROCEDURE [dbo].[spGrantExec]\n@User SysName,\n@DbName VarChar(512)\nAS\nBEGIN\nDECLARE @Sql VarChar(1024)</p>\n\n<p>SET @Sql = 'DECLARE @OwnerName varchar(128)\nDECLARE @ObjectName varchar(128)\nDECLARE @Cmd1 VarChar(128)\nDECLARE ProcCursor CURSOR FOR\nSELECT ROUTINE SCHEMA, ROUTINE NAME\nFROM @DbName.INFORMATION SCHEMA.ROUTINES \nWHERE ROUTINENAME NOT LIKE ''dt %'' AND ROUTINE TYPE = ''PROCEDURE''\nOPEN ProcCursor\nFETCH NEXT FROM ProcCursor INTO @OwnerName, @ObjectName\nWHILE @@FETCH STATUS = 0\nBEGIN\nSET @CMD1 = ''GRANT EXEC ON '' + ''['' + @OwnerName + '']'' + ''.'' + ''['' + @ObjectName + '']'' + '' TO '' + ''@user''\nEXEC (@CMD1)</p>\n\n<p>FETCH NEXT FROM ProcCursor INTO @OwnerName, @ObjectName\nEND\nCLOSE ProcCursor\nDEALLOCATE ProcCursor\n'</p>\n\n<p>SET @Sql = Replace(Replace(@Sql, '@DbName', @DbName), '@user', @User)\nEXEC (@Sql)</p>\n\n<p>END