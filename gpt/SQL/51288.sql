CREATE TABLE your_table_name (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    url_column TEXT,\n    -- Other columns here...\n\n    -- Add unique constraint\n    UNIQUE (url_column)\n);