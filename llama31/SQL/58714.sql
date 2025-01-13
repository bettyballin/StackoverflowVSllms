SELECT \n  department_id,\n  salary,\n  AVG(salary) OVER (PARTITION BY department_id) AS avg_salary\nFROM \n  employees;