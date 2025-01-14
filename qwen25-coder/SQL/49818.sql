CREATE TABLE failed_login_attempts (\n       id INT AUTO_INCREMENT PRIMARY KEY,\n       ip_address VARCHAR(45) NOT NULL,\n       username VARCHAR(255),\n       attempt_time DATETIME DEFAULT CURRENT_TIMESTAMP,\n       INDEX composite_index (ip_address, username, attempt_time)\n   );