CREATE PROCEDURE GetTopResults\n    @NumberOfResultsToReturn INT\nAS\nBEGIN\n    DECLARE @SQL NVARCHAR(MAX)\n    \n    SET @SQL = 'SELECT TOP ' + CAST(@NumberOfResultsToReturn AS NVARCHAR(10)) + ' * FROM YourTableName'\n    \n    EXEC sp_executesql @SQL\nEND