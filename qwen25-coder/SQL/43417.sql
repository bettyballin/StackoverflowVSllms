SELECT employee, department, salary,\n          RANK() OVER (PARTITION BY department ORDER BY salary DESC) as rank\n   FROM employees;