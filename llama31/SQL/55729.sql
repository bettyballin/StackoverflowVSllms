CREATE TABLE customers (\n  id INT PRIMARY KEY,\n  name VARCHAR(255)\n);\n\nCREATE TABLE orders (\n  id INT PRIMARY KEY,\n  customer_id INT,\n  FOREIGN KEY (customer_id) REFERENCES customers(id)\n);