CREATE TABLE oauth_tokens (\n    id INT PRIMARY KEY AUTO_INCREMENT,\n    user_id INT NOT NULL,\n    access_token VARCHAR(512) NOT NULL,\n    access_secret VARCHAR(512) NOT NULL,\n    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n    FOREIGN KEY (user_id) REFERENCES users(id)\n);