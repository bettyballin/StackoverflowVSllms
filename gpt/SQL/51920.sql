CREATE TABLE received_sms (\n       id INT AUTO_INCREMENT PRIMARY KEY,\n       from_number VARCHAR(50),\n       message_body TEXT,\n       received_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n   );