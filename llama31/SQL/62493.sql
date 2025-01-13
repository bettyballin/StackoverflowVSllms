CREATE TRIGGER update_field\nAFTER UPDATE ON table1\nFOR EACH ROW\nBEGIN\n    IF OLD.field1 != NEW.field1 THEN\n        UPDATE table2\n        SET field2 = NEW.field1\n        WHERE id = NEW.id;\n    END IF;\nEND;