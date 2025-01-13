CREATE TRIGGER after_update_my_table\n   AFTER UPDATE ON my_table\n   FOR EACH ROW\n   BEGIN\n       INSERT INTO my_table_changes (table_name, operation, row_id, timestamp)\n       VALUES ('my_table', 'update', OLD.id, NOW());\n   END;