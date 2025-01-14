CREATE TYPE EmployeeType AS OBJECT (\n    employee_id NUMBER,\n    name VARCHAR2(50)\n);\n/\n\n-- Create a nested table type to hold multiple employees\nCREATE TYPE EmployeesTable AS TABLE OF EmployeeType;\n/\n\nCREATE TYPE DepartmentType AS OBJECT (\n    department_id NUMBER,\n    department_name VARCHAR2(50),\n    employees EmployeesTable -- holds collection of EmployeeType\n) NESTED TABLE employees STORE AS EmpsTableStorage;\n/