SELECT * FROM employees\nSTART WITH manager_id is null AND dept_id = 'SALE'\nCONNECT BY PRIOR employee_id = manager_id