CREATE TABLE users (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    unique_user_id CHAR(64) NOT NULL,\n    created_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n    -- other fields\n    UNIQUE KEY (unique_user_id)\n);