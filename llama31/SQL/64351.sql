CREATE TABLE audit_trail (\n  id INT PRIMARY KEY,\n  table_name VARCHAR(255),\n  field_name VARCHAR(255),\n  old_value TEXT,\n  new_value TEXT,\n  changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n  changed_by INT\n);\n\nDELIMITER ;;\nCREATE TRIGGER trg_user_update\nAFTER UPDATE ON users\nFOR EACH ROW\nBEGIN\n  IF NEW.name != OLD.name THEN\n    INSERT INTO audit_trail (table_name, field_name, old_value, new_value, changed_by)\n    VALUES ('users', 'name', OLD.name, NEW.name, CURRENT_USER());\n  END IF;\nEND;;\nDELIMITER ;