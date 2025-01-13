CREATE PROCEDURE GetLogs\n    @BeginDate datetime,\n    @EndDate datetime,\n    @UserName nvarchar(50) = NULL\nAS\nBEGIN\n    DECLARE @sql nvarchar(max)\n    SET @sql = N'SELECT * FROM weblogs.dbo.vwlogs WHERE Log_time BETWEEN @BeginDate AND @EndDate'\n\n    IF @UserName IS NOT NULL\n    BEGIN\n        SET @sql = @sql + N' AND client_user = @UserName'\n    END\n\n    EXEC sp_executesql @sql, N'@BeginDate datetime, @EndDate datetime, @UserName nvarchar(50)', \n                       @BeginDate = @BeginDate, @EndDate = @EndDate, @UserName = @UserName\nEND