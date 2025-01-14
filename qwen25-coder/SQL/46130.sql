CREATE TABLE users (\n    user_id INT AUTO_INCREMENT PRIMARY KEY,\n    username VARCHAR(255) NOT NULL UNIQUE,\n    password_hash VARCHAR(255) NOT NULL,\n    email VARCHAR(255) NOT NULL UNIQUE,\n    status TEXT\n);\n\nCREATE TABLE friends (\n    friendship_id INT AUTO_INCREMENT PRIMARY KEY,\n    user1_id INT,\n    user2_id INT,\n    FOREIGN KEY (user1_id) REFERENCES users(user_id),\n    FOREIGN KEY (user2_id) REFERENCES users(user_id)\n);