WITH NumberedIntervals AS (\n    SELECT \n        ID,\n        startDate,\n        endDate,\n        ID - ROW_NUMBER() OVER (PARTITION BY ID ORDER BY startDate) AS grp\n    FROM your_table\n),\nGroupedIntervals AS (\n    SELECT \n        ID,\n        grp,\n        MIN(startDate) AS minStartDate,\n        MAX(endDate)   AS maxEndDate\n    FROM NumberedIntervals\n    GROUP BY ID, grp\n)\nSELECT \n    ID,\n    minStartDate,\n    maxEndDate\nFROM GroupedIntervals\nORDER BY ID, minStartDate;