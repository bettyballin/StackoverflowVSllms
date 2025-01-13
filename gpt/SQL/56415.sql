CREATE TABLE books_audit (\n    id INT,\n    name VARCHAR(255),\n    operation CHAR(1), -- 'I' for insert, 'D' for delete\n    operation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n);