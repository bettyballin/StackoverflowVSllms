-- Create a table with an index on the 'id' column\nCREATE TABLE mytable (\n    id SERIAL PRIMARY KEY,\n    name VARCHAR(50),\n    email VARCHAR(100)\n);\n\n-- Create an index on the 'email' column\nCREATE INDEX idx_email ON mytable (email);\n\n-- Query the 'email' column using the index\nSELECT * FROM mytable WHERE email = 'example@example.com';  -- O(1) complexity\n\n-- Query another column without an index\nSELECT * FROM mytable WHERE name = 'John Doe';  -- O(n) complexity