-- Create a new table\nCREATE TABLE users (\n    id INTEGER PRIMARY KEY,\n    name TEXT NOT NULL,\n    email TEXT UNIQUE NOT NULL\n);\n\n-- Insert data into the table\nINSERT INTO users (name, email) VALUES ('Alice', 'alice@example.com');\nINSERT INTO users (name, email) VALUES ('Bob', 'bob@example.com');\n\n-- Query data from the table\nSELECT * FROM users;\n\n-- Update data in the table\nUPDATE users SET email = 'alice@newdomain.com' WHERE id = 1;\n\n-- Delete data from the table\nDELETE FROM users WHERE id = 2;