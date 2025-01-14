-- Create a table\nCREATE TABLE employees (\n    id SERIAL PRIMARY KEY,\n    first_name VARCHAR(50),\n    last_name VARCHAR(50)\n);\n\n-- Create a function index on the lower case of the last_name column\nCREATE INDEX idx_lower_last_name ON employees (LOWER(last_name));\n\n-- Query the table using the function\nSELECT * FROM employees WHERE LOWER(last_name) = 'doe';