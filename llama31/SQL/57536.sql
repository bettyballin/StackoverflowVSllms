CREATE PROCEDURE AnalyzeMethodCallData\n    @TimePeriod nvarchar(50) = 'last_min', -- options: last_min, last_hour, last_day, last_week, last_month\n    @ApplicationName nvarchar(50) = NULL -- optional, if NULL, returns data for all applications\nAS\nBEGIN\n    DECLARE @StartDate datetime, @EndDate datetime\n\n    -- set date range based on @TimePeriod\n    IF @TimePeriod = 'last_min'\n        SET @StartDate = DATEADD(minute, -1, GETDATE())\n    ELSE IF @TimePeriod = 'last_hour'\n        SET @StartDate = DATEADD(hour, -1, GETDATE())\n    ELSE IF @TimePeriod = 'last_day'\n        SET @StartDate = DATEADD(day, -1, GETDATE())\n    ELSE IF @TimePeriod = 'last_week'\n        SET @StartDate = DATEADD(week, -1, GETDATE())\n    ELSE IF @TimePeriod = 'last_month'\n        SET @StartDate = DATEADD(month, -1, GETDATE())\n\n    SET @EndDate = GETDATE()\n\n    -- get average length of time for method call\n    SELECT \n        AVG(TimeInMs) AS AverageTime\n    FROM \n        YourTable\n    WHERE \n        (@ApplicationName IS NULL OR ApplicationName = @ApplicationName)\n        AND DateTime >= @StartDate\n        AND DateTime <= @EndDate\n\n    -- get top ten slowest method calls\n    SELECT TOP 10 \n        MethodName, \n        AVG(TimeInMs) AS AverageTime\n    FROM \n        YourTable\n    WHERE \n        (@ApplicationName IS NULL OR ApplicationName = @ApplicationName)\n        AND DateTime >= @StartDate\n        AND DateTime <= @EndDate\n    GROUP BY \n        MethodName\n    ORDER BY \n        AverageTime DESC\n\n    -- get top ten fastest method calls\n    SELECT TOP 10 \n        MethodName, \n        AVG(TimeInMs) AS AverageTime\n    FROM \n        YourTable\n    WHERE \n        (@ApplicationName IS NULL OR ApplicationName = @ApplicationName)\n        AND DateTime >= @StartDate\n        AND DateTime <= @EndDate\n    GROUP BY \n        MethodName\n    ORDER BY \n        AverageTime ASC\nEND