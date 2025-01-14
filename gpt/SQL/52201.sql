CREATE FUNCTION dbo.IsTimeRangeCovered (\n    @StartTime DATETIME,\n    @EndTime DATETIME\n)\nRETURNS BIT\nAS\nBEGIN\n    DECLARE @Result BIT = 0;\n\n    -- Temporary table to store merged intervals\n    CREATE TABLE #MergedIntervals (\n        StartTime DATETIME,\n        EndTime DATETIME\n    );\n\n    -- Insert the initial intervals into the temporary table\n    INSERT INTO #MergedIntervals (StartTime, EndTime)\n    SELECT Start, [End]\n    FROM Shifts\n    WHERE Start <= @EndTime AND [End] >= @StartTime;\n\n    -- Merge overlapping intervals\n    DECLARE @CurrentStart DATETIME, @CurrentEnd DATETIME;\n\n    WHILE EXISTS (SELECT 1 FROM #MergedIntervals)\n    BEGIN\n        SELECT TOP 1 @CurrentStart = StartTime, @CurrentEnd = EndTime\n        FROM #MergedIntervals\n        ORDER BY StartTime;\n\n        DELETE FROM #MergedIntervals WHERE StartTime = @CurrentStart AND EndTime = @CurrentEnd;\n\n        -- Merge intervals that overlap or touch\n        WHILE EXISTS (SELECT 1 FROM #MergedIntervals WHERE StartTime <= @CurrentEnd AND EndTime >= @CurrentStart)\n        BEGIN\n            SELECT TOP 1 @CurrentStart = CASE WHEN StartTime < @CurrentStart THEN StartTime ELSE @CurrentStart END,\n                         @CurrentEnd = CASE WHEN EndTime > @CurrentEnd THEN EndTime ELSE @CurrentEnd END\n            FROM #MergedIntervals\n            WHERE StartTime <= @CurrentEnd AND EndTime >= @CurrentStart;\n\n            DELETE FROM #MergedIntervals WHERE StartTime <= @CurrentEnd AND EndTime >= @CurrentStart;\n        END;\n\n        -- Insert the merged interval back to the temporary table\n        INSERT INTO #MergedIntervals (StartTime, EndTime)\n        VALUES (@CurrentStart, @CurrentEnd);\n    END;\n\n    -- Check if the entire time range is covered\n    IF EXISTS (\n        SELECT 1\n        FROM #MergedIntervals\n        WHERE StartTime <= @StartTime AND EndTime >= @EndTime\n    )\n    BEGIN\n        SET @Result = 1;\n    END\n\n    -- Clean up\n    DROP TABLE #MergedIntervals;\n\n    RETURN @Result;\nEND