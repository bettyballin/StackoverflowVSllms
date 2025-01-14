SELECT e.*\nFROM employee e\nJOIN (\n    SELECT department, MIN(salary) AS min_salary\n    FROM employee\n    GROUP BY department\n) dept_min ON e.department = dept_min.department AND e.salary = dept_min.min_salary;