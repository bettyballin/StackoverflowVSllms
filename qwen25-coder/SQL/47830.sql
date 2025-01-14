-- Table to manage stores\nCREATE TABLE stores (\n    store_id INT PRIMARY KEY,\n    store_name VARCHAR(255)\n);\n\n-- Table to manage items that can be added to stores\nCREATE TABLE items (\n    item_id INT PRIMARY KEY,\n    item_name VARCHAR(255),\n    is_active BOOLEAN DEFAULT TRUE\n);\n\n-- Linking table for many-to-many relationship between stores and items\nCREATE TABLE store_items (\n    store_item_id INT PRIMARY KEY AUTO_INCREMENT,\n    store_id INT,\n    item_id INT,\n    FOREIGN KEY (store_id) REFERENCES stores(store_id),\n    FOREIGN KEY (item_id) REFERENCES items(item_id)\n);\n\n-- Table to store data entries with flexible schema using JSON or key-value pairs\nCREATE TABLE store_data (\n    entry_id INT PRIMARY KEY AUTO_INCREMENT,\n    store_id INT,\n    item_id INT,\n    value VARCHAR(255),  -- Or use TEXT if you need more space, or even JSON for complex types\n    FOREIGN KEY (store_id) REFERENCES stores(store_id),\n    FOREIGN KEY (item_id) REFERENCES items(item_id)\n);