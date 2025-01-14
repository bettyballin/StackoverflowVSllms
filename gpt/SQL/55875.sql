WITH GradeCounts AS (\n    SELECT grade, COUNT(*) AS count\n    FROM YourTable\n    GROUP BY grade\n),\nAllGrades AS (\n    SELECT 1 AS grade UNION ALL\n    SELECT 2 UNION ALL\n    SELECT 3 UNION ALL\n    SELECT 4 UNION ALL\n    SELECT 5 UNION ALL\n    SELECT 6\n)\nSELECT \n    STRING_AGG(ISNULL(gc.count, 0), ',') WITHIN GROUP (ORDER BY ag.grade) AS histogram\nFROM \n    AllGrades ag\nLEFT JOIN \n    GradeCounts gc\nON \n    ag.grade = gc.grade;