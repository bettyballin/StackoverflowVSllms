CREATE TABLE searchterms (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    terms VARCHAR(255) NOT NULL,\n    search_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n    user_id INT NULL,\n    user_ip VARCHAR(45) NOT NULL\n);