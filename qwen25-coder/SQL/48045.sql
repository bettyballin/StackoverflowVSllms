-- Create an audit log table\nCREATE TABLE books_audit_log (\n    id INT AUTO_INCREMENT PRIMARY KEY,\n    book_id INT NOT NULL,\n    operation CHAR(1) NOT NULL, -- 'I' for insert, 'D' for delete\n    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP\n);\n\n-- Trigger to log inserts\nDELIMITER $$\nCREATE TRIGGER after_books_insert AFTER INSERT ON books\nFOR EACH ROW \nBEGIN\n   INSERT INTO books_audit_log (book_id, operation) VALUES (NEW.id, 'I');\nEND$$\nDELIMITER ;\n\n-- Trigger to log deletes\nDELIMITER $$\nCREATE TRIGGER after_books_delete AFTER DELETE ON books\nFOR EACH ROW \nBEGIN\n   INSERT INTO books_audit_log (book_id, operation) VALUES (OLD.id, 'D');\nEND$$\nDELIMITER ;