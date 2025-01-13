CREATE TABLE topics (\n        id INT AUTO_INCREMENT PRIMARY KEY,\n        title VARCHAR(255) NOT NULL,\n        content TEXT NOT NULL,\n        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n    );\n\n    CREATE TABLE comments (\n        id INT AUTO_INCREMENT PRIMARY KEY,\n        topic_id INT NOT NULL,\n        content TEXT NOT NULL,\n        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n        FOREIGN KEY (topic_id) REFERENCES topics(id)\n    );