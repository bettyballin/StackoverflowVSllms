CREATE TABLE events (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    event_name VARCHAR(255),\n    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n);