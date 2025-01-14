WITH ValueRanges AS (\n    SELECT\n        CASE\n            WHEN value BETWEEN 10 AND 20 THEN '10-20'\n            WHEN value BETWEEN 20 AND 32.5 THEN '20-32.5'\n            ELSE 'Other'\n        END AS Range,\n        COUNT(*) AS CountInRange\n    FROM YourTable\n    GROUP BY \n        CASE\n            WHEN value BETWEEN 10 AND 20 THEN '10-20'\n            WHEN value BETWEEN 20 AND 32.5 THEN '20-32.5'\n            ELSE 'Other'\n        END\n),\nTotalCount AS (\n    SELECT COUNT(*) AS TotalCount FROM YourTable\n)\nSELECT\n    Range,\n    CountInRange,\n    (CountInRange * 100.0 / TotalCount) AS Percentage\nFROM ValueRanges, TotalCount;