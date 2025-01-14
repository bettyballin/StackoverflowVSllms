CREATE TABLE images (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    filename VARCHAR(255),\n    path VARCHAR(255), -- Path to where the actual file is stored\n    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n    description TEXT,\n    tags JSON                     -- Storing tags or any other attributes as needed\n);