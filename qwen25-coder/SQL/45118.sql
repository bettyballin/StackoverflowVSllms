SELECT * FROM (\n                  SELECT * FROM employees \n                   WHERE dept_id = 'SALE'\n                 )\n   START WITH manager_id is null\n   CONNECT BY PRIOR employee_id = manager_id;