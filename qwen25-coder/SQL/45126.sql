CREATE TABLE carts (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    user_id INT,  -- Assuming each cart is associated with a user\n    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n);\n\nCREATE TABLE items (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    name VARCHAR(255),\n    price DECIMAL(10, 2)\n);\n\nCREATE TABLE cart_items (\n    id INT AUTO_INCREMENT PRIMARY KEY,  -- New primary key for each cart_item record\n    cart_id INT,\n    item_id INT,\n    quantity INT DEFAULT 1,\n    FOREIGN KEY (cart_id) REFERENCES carts(id),\n    FOREIGN KEY (item_id) REFERENCES items(id)\n);