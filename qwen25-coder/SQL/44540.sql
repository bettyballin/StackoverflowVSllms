IF (@DateStart IS NOT NULL)\nBEGIN\n    SET @DateStart = CAST(CAST(@DateStart AS DATE) AS DATETIME)\nEND\n\nIF (@DateEnd IS NOT NULL)\nBEGIN\n    SET @DateEnd = DATEADD(DAY, 1, CAST(CAST(@DateEnd AS DATE) AS DATETIME))\nEND\n\nWHERE (EventDate >= @DateStart AND EventDate < @DateEnd)