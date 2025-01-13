CREATE TABLE customers (\n    id SERIAL PRIMARY KEY,\n    name VARCHAR(50)\n);\n\nCREATE TABLE orders (\n    id SERIAL PRIMARY KEY,\n    customer_id INTEGER NOT NULL,\n    FOREIGN KEY (customer_id) REFERENCES customers(id)\n        ON UPDATE CASCADE\n        ON DELETE SET NULL\n);