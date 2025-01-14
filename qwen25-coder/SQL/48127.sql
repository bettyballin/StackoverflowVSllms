-- Avoid this\n   SELECT name FROM employees WHERE department_id = (SELECT id FROM departments WHERE name = 'Sales');\n   \n   -- Prefer this\n   SELECT e.name FROM employees e JOIN departments d ON e.department_id = d.id WHERE d.name = 'Sales';