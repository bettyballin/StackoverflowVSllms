WITH AggregatedCounts AS (\n    SELECT matchCode1, matchCode2, matchCode3, COUNT(employee_id) AS test_count\n    FROM sourceTable\n    GROUP BY matchCode1, matchCode2, matchCode3\n)\nUPDATE destTable d\nSET test_count = ac.test_count\nFROM AggregatedCounts ac\nWHERE d.matchCode1 = ac.matchCode1 AND\n      d.matchCode2 = ac.matchCode2 AND\n      d.matchCode3 = ac.matchCode3;