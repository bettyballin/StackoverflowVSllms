UPDATE destTable d\nJOIN (\n  SELECT matchCode1, matchCode2, matchCode3, COUNT(employee_id) as test_count\n  FROM sourceTable\n  GROUP BY matchCode1, matchCode2, matchCode3, employee_id\n) s ON d.matchCode1 = s.matchCode1 AND d.matchCode2 = s.matchCode2 AND d.matchCode3 = s.matchCode3\nSET d.test_count = s.test_count;