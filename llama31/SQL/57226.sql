CREATE PROCEDURE dbo.spPivot (@EntityTypeID int)\nAS\nBEGIN\n    DECLARE @SQL nvarchar(MAX);\n    DECLARE @COLS nvarchar(MAX);\n\n    SELECT @COLS = COALESCE(@COLS + ',', '') + '[' + Name + ']'\n    FROM c_EntityAttribute\n    WHERE EntityTypeID = @EntityTypeID;\n\n    SET @SQL = N'SELECT * FROM (SELECT EntityInstanceID, AttributeName, Value FROM v_EntityElementData WHERE EntityTypeID = @EntityTypeID) as s';\n    SET @SQL = @SQL + N' PIVOT ( MIN(Value) FOR AttributeName IN (' + @COLS + ') ) AS p';\n\n    EXEC sp_ExecuteSQL @SQL, N'@EntityTypeID int', @EntityTypeID = @EntityTypeID;\nEND