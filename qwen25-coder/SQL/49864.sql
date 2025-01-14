CREATE TABLE revisions (\n       revision_id INT PRIMARY KEY AUTO_INCREMENT,\n       document_id INT NOT NULL,\n       parent_revision_id INT DEFAULT NULL, -- the ID of the previous version\n       diff TEXT, -- the changes from the parent to this version\n       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n       FOREIGN KEY (document_id) REFERENCES documents(document_id)\n   );\n\n   CREATE TABLE documents (\n       document_id INT PRIMARY KEY AUTO_INCREMENT,\n       current_revision_id INT, -- points to the most recent revision ID\n       title VARCHAR(255),\n       content TEXT, -- stores the full text of the most recent version\n       FOREIGN KEY (current_revision_id) REFERENCES revisions(revision_id)\n   );