CREATE SCHEMA linq_schema;\nGO\n\nCREATE TABLE linq_schema.customers (\n    id INT PRIMARY KEY,\n    name VARCHAR(50)\n);\nGO\n\nGRANT SELECT ON SCHEMA::linq_schema TO your_linq_user;\nGO