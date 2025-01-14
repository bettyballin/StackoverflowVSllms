WITH CTE AS (\n    SELECT EmpId, EmpName, EmpSSN,\n           ROW_NUMBER() OVER (PARTITION BY EmpId, EmpSSN ORDER BY EmpId) AS rn\n    FROM employee\n)\nDELETE FROM employee\nWHERE ROWID IN (\n    SELECT ROWID\n    FROM CTE\n    WHERE rn > 1\n);