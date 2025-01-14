CREATE TABLE login_attempts (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    user_id VARCHAR(255) NOT NULL,\n    ip_address VARCHAR(45),\n    attempt_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP\n);