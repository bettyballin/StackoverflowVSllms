CREATE TABLE images (\n  id INT PRIMARY KEY AUTO_INCREMENT,\n  image BLOB NOT NULL,\n  mime_type VARCHAR(50) NOT NULL,\n  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n);