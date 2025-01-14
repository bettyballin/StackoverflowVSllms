CREATE TABLE attributes (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    attribute_name VARCHAR(255) NOT NULL,\n    str_value TEXT,\n    int_value INTEGER,\n    dec_value DECIMAL(10, 2),\n    value_type ENUM('string', 'integer', 'decimal') NOT NULL\n);