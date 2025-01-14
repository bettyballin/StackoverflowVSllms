SELECT e.*\nFROM employee e\nWHERE e.department = 'sales'\n  AND e.salary = (\n      SELECT MIN(salary)\n      FROM employee\n      WHERE department = 'sales'\n  );