CREATE TABLE users (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    username VARCHAR(50) NOT NULL,\n    status VARCHAR(20) NOT NULL DEFAULT 'active'\n);