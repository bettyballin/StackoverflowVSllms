CREATE TABLE emails (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    email VARCHAR(255) NOT NULL,\n    name VARCHAR(255) NOT NULL,\n    subject VARCHAR(255) NOT NULL,\n    received_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n);