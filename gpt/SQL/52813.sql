DECLARE @TestVal int\nSET @TestVal = 5\n\nSELECT\n    CASE\n        WHEN @TestVal <= 3 THEN 'Top 3'\n        WHEN (SELECT 1) = 1 THEN 'Other Value'\n        WHEN (SELECT 2) = 2 THEN 'Other Value 2'\n        ELSE 'Other'\n    END AS Result