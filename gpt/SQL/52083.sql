CREATE TABLE documents (\n    document_id INT PRIMARY KEY,\n    document_name VARCHAR(255),\n    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n);\n\nCREATE TABLE document_rows (\n    row_id BIGINT AUTO_INCREMENT PRIMARY KEY,\n    document_id INT,\n    chapter INT,\n    row_content TEXT,\n    other_values JSON,\n    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n    FOREIGN KEY (document_id) REFERENCES documents(document_id)\n);\n\nCREATE INDEX idx_document_id ON document_rows(document_id);