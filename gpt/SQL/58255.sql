SELECT empid, dept, sal\nFROM employee_table\nORDER BY (SELECT COUNT(*)\n          FROM employee_table AS e\n          WHERE e.dept = employee_table.dept) DESC, dept, empid;