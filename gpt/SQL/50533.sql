CREATE TABLE scheduled_emails (\n       id INT AUTO_INCREMENT PRIMARY KEY,\n       recipient VARCHAR(255) NOT NULL,\n       subject VARCHAR(255) NOT NULL,\n       message TEXT NOT NULL,\n       headers TEXT NOT NULL,\n       scheduled_time DATETIME NOT NULL,\n       sent BOOLEAN DEFAULT FALSE\n   );