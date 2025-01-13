CREATE OR REPLACE TRIGGER monitor_update\nAFTER UPDATE ON your_table_name\nFOR EACH ROW\nBEGIN\n  INSERT INTO your_audit_table (username, update_date, old_values, new_values, update_statement)\n  VALUES (SYS_CONTEXT('USERENV', 'SESSION_USER'), SYSTIMESTAMP, :OLD, :NEW, SYS_CONTEXT('USERENV', 'CURRENT_SQL'));\nEND;