-- Example of a secure DB2 SQL query using a prepared statement\nPREPARE stmt FROM 'SELECT * FROM employees WHERE name = ?';\nEXECUTE stmt USING 'John Doe';