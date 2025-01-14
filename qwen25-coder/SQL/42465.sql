-- Example SQL: Creating a table with CHECK constraint for email\n   CREATE TABLE users (\n       id INT PRIMARY KEY AUTO_INCREMENT,\n       email VARCHAR(255) NOT NULL CHECK (email REGEXP '^[^@]+@[^@]+\.[^@]+$')\n   );