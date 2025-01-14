CREATE PROCEDURE AccessOtherDatabase\n    @BaseDatabaseName NVARCHAR(128)\nAS\nBEGIN\n    DECLARE @OtherDatabaseName NVARCHAR(128)\n    DECLARE @SQL NVARCHAR(MAX)\n\n    -- Construct the name of the other database\n    SET @OtherDatabaseName = @BaseDatabaseName + '_2'\n\n    -- Construct the SQL statement to access the other database\n    SET @SQL = N'\n        USE ' + QUOTENAME(@OtherDatabaseName) + ';\n        -- Your query here, for example:\n        SELECT * FROM ' + QUOTENAME(@OtherDatabaseName) + '.dbo.YourTableName;\n    '\n\n    -- Execute the constructed SQL statement safely\n    EXEC sp_executesql @SQL\nEND