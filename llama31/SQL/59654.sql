WITH UserHistoryCTE AS (\n    SELECT\n        UserId,\n        CreationDate,\n        ROW_NUMBER() OVER (PARTITION BY UserId ORDER BY CreationDate) AS RN\n    FROM\n        UserHistory\n)\nSELECT\n    UH1.UserId\nFROM\n    UserHistoryCTE UH1\n    JOIN UserHistoryCTE UH2 ON UH1.UserId = UH2.UserId AND UH1.RN + 1 = UH2.RN\nWHERE\n    DATEDIFF(day, UH1.CreationDate, UH2.CreationDate) = 1\nGROUP BY\n    UH1.UserId\nHAVING\n    COUNT(DISTINCT UH1.RN) >= @n;