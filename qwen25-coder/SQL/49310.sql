CREATE PROCEDURE dbo.GetConcatenatedField\n    @qry nvarchar(max),\n    @fld nvarchar(128),\n    @separator nvarchar(15) = '; ',\n    @result nvarchar(max) OUTPUT\nAS\nBEGIN\n    DECLARE @sql nvarchar(max);\n\n    SET @sql = 'SELECT @rslt = COALESCE(@rslt + ''' + @separator + ''', '''') + CAST(' + QUOTENAME(@fld) + ' AS nvarchar(max)) FROM (' + @qry + ') X';\n\n    EXEC sp_executesql \n        @sql, \n        N'@rslt nvarchar(max) OUTPUT',\n        @result OUTPUT;\nEND