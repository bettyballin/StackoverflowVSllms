CREATE TABLE IF NOT EXISTS subscribers (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    name VARCHAR(255) NOT NULL,\n    email VARCHAR(255) NOT NULL UNIQUE\n);