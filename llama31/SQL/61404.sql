WITH RECURSIVE concatenated_strings AS (\n  SELECT deptno, ename, 1 AS level,\n         CAST(ename AS CLOB) AS concatenated_string\n  FROM wd_emp\n  WHERE row_number = 1\n  UNION ALL\n  SELECT e.deptno, e.ename, level + 1,\n         DBMS_LOB.CONCAT(c.concatenated_string, ',' || e.ename)\n  FROM wd_emp e\n  JOIN concatenated_strings c ON e.deptno = c.deptno AND e.row_number = c.level + 1\n)\nSELECT deptno, concatenated_string\nFROM concatenated_strings\nWHERE level = (SELECT MAX(row_count) FROM wd_emp);