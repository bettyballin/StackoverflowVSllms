-- Create a separate schema for demo data\nCREATE SCHEMA demo;\n\n-- Create demo tables in the demo schema\nCREATE TABLE demo.customers (\n  id INT PRIMARY KEY,\n  name VARCHAR(255)\n);\n\n-- Use a different connection string or schema name for demo data