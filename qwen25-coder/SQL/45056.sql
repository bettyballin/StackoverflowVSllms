CREATE TABLE user_widget_positions (\n        id INT AUTO_INCREMENT PRIMARY KEY,\n        user_id INT NOT NULL,\n        widget_id VARCHAR(50) NOT NULL,\n        position JSON NOT NULL,\n        FOREIGN KEY (user_id) REFERENCES users(id)\n    );