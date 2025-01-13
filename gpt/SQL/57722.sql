-- Anti-pattern: Unnormalized table\n   CREATE TABLE orders (\n       id INT,\n       customer_name VARCHAR(255),\n       customer_address VARCHAR(255),\n       product_name VARCHAR(255),\n       product_price DECIMAL\n   );\n\n   -- Better approach: Normalized tables\n   CREATE TABLE customers (\n       id INT PRIMARY KEY,\n       name VARCHAR(255),\n       address VARCHAR(255)\n   );\n\n   CREATE TABLE products (\n       id INT PRIMARY KEY,\n       name VARCHAR(255),\n       price DECIMAL\n   );\n\n   CREATE TABLE orders (\n       id INT PRIMARY KEY,\n       customer_id INT,\n       product_id INT\n   );