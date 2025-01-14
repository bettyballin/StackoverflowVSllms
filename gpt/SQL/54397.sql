-- Start a transaction\nBEGIN TRANSACTION;\n\n-- Perform some DML operations\nINSERT INTO employees (id, name) VALUES (1, 'John Doe');\nUPDATE employees SET name = 'Jane Doe' WHERE id = 1;\n\n-- Perform a DDL operation\nTRUNCATE TABLE employees;\n\n-- The transaction is automatically committed before and after the TRUNCATE statement\n-- No need to explicitly commit\n\n-- Verify the changes\nSELECT * FROM employees;