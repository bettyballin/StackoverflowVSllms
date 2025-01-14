SELECT \n    e.department_id, \n    AVG(e.salary) AS avg_salary, \n    COUNT(*) AS num_employees\nFROM \n    employees e\nJOIN \n    departments d ON e.department_id = d.department_id\nWHERE \n    e.hire_date >= DATE '2015-01-01'\nGROUP BY \n    e.department_id\nHAVING \n    AVG(e.salary) > 50000;