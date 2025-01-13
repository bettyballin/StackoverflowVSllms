CREATE TABLE users (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    first_name VARCHAR(50),\n    last_name VARCHAR(50)\n);\n\n-- Create an index on the first_name column to facilitate efficient searches\nCREATE INDEX idx_first_name ON users (first_name);