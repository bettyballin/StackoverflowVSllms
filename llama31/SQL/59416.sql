SELECT department, employee_name, MAX(salary) \nFROM employees \nGROUP BY department;