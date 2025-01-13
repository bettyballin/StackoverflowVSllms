CREATE TABLE products (\n  id INT PRIMARY KEY,\n  name VARCHAR(255),\n  description TEXT,\n  ...\n);\n\nCREATE TABLE categories (\n  id INT PRIMARY KEY,\n  name VARCHAR(255),\n  description TEXT,\n  ...\n);\n\nCREATE TABLE product_scores (\n  id INT PRIMARY KEY,\n  product_id INT,\n  category_id INT,\n  score TINYINT,\n  FOREIGN KEY (product_id) REFERENCES products(id),\n  FOREIGN KEY (category_id) REFERENCES categories(id)\n);