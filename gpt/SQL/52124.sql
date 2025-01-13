WITH EventData AS (\n    SELECT\n        eventId,\n        startDate,\n        ISNULL(endDate, '9999-12-31') AS endDate\n    FROM\n        Events\n),\nDateRange AS (\n    SELECT\n        '2009-04-01' AS startDate,\n        '2009-06-30' AS endDate\n),\nAllDates AS (\n    SELECT\n        startDate AS eventDate, 1 AS eventType\n    FROM\n        EventData\n    UNION ALL\n    SELECT\n        endDate, -1\n    FROM\n        EventData\n    UNION ALL\n    SELECT\n        startDate, 0\n    FROM\n        DateRange\n    UNION ALL\n    SELECT\n        endDate, 0\n    FROM\n        DateRange\n),\nOrderedDates AS (\n    SELECT\n        eventDate,\n        eventType,\n        SUM(eventType) OVER (ORDER BY eventDate ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS eventCount\n    FROM\n        AllDates\n),\nResultRanges AS (\n    SELECT\n        eventDate AS startDate,\n        LEAD(eventDate, 1) OVER (ORDER BY eventDate) AS endDate,\n        eventCount\n    FROM\n        OrderedDates\n)\nSELECT\n    CASE\n        WHEN eventCount = 0 THEN 'no event: '\n        WHEN eventCount > 1 THEN 'overlap : '\n        ELSE NULL\n    END + CONVERT(VARCHAR, startDate, 103) + ' - ' + CONVERT(VARCHAR, DATEADD(DAY, -1, endDate), 103) AS Result\nFROM\n    ResultRanges\nWHERE\n    eventCount = 0 OR eventCount > 1\nAND\n    endDate IS NOT NULL\nAND\n    startDate < endDate\nORDER BY\n    startDate;