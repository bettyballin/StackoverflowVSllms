-- Suppose we have a table named 'employees' with columns 'id', 'name', 'department', and 'salary'\n\n-- A covered index for a query that selects 'name' and 'department' where 'department' = 'Sales'\n-- would look like this:\n\nCREATE INDEX idx_employees_department_name\nON employees (department, name);\n\n-- Now, a query like the following can be fully satisfied using the index:\nSELECT name, department\nFROM employees\nWHERE department = 'Sales';