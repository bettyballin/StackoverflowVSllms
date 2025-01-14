CREATE PROCEDURE dbo.ConcatFieldFromQuery\n    @qry NVARCHAR(MAX),\n    @fld NVARCHAR(100),\n    @separator NVARCHAR(15) = '; '\nAS\nBEGIN\n    DECLARE @sql NVARCHAR(MAX);\n    DECLARE @rslt NVARCHAR(MAX) = '';\n\n    -- Construct dynamic SQL query\n    SET @sql = N'SELECT @rslt = STRING_AGG(CAST(' + @fld + ' AS NVARCHAR(MAX)), ''' + @separator + ''')\n                FROM (' + @qry + ') AS SubQuery';\n\n    -- Execute dynamic SQL\n    EXEC sp_executesql @sql, N'@rslt NVARCHAR(MAX) OUTPUT', @rslt OUTPUT;\n\n    -- Return result\n    SELECT @rslt AS Result;\nEND;