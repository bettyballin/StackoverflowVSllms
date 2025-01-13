CREATE TABLE notifications (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    text VARCHAR(255) NOT NULL,\n    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n);\n\nCREATE TABLE alerts (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    user_id INT NOT NULL,\n    notification_id INT NOT NULL,\n    FOREIGN KEY (notification_id) REFERENCES notifications(id),\n    FOREIGN KEY (user_id) REFERENCES users(id)\n);