CREATE TABLE products (\n  id INT PRIMARY KEY,\n  name VARCHAR(255),\n  description TEXT\n);\n\nCREATE TABLE product_translations (\n  product_id INT,\n  locale VARCHAR(10),\n  name VARCHAR(255),\n  description TEXT,\n  PRIMARY KEY (product_id, locale),\n  FOREIGN KEY (product_id) REFERENCES products(id)\n);