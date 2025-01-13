CREATE OR REPLACE TRIGGER LOG_EXAMPLE_TABLE_CHANGES\nAFTER INSERT OR UPDATE OR DELETE ON EXAMPLE_TABLE\nFOR EACH ROW\nBEGIN\n    IF INSERTING THEN\n        INSERT INTO LOG_TABLE (LOG_ID, TABLE_NAME, ROW_ID, OPERATION, CHANGE_DATE, NEW_DATA)\n        VALUES (LOG_SEQ.NEXTVAL, 'EXAMPLE_TABLE', :NEW.ID, 'INSERT', SYSTIMESTAMP, XMLFOREST(:NEW.ID, :NEW.NAME, :NEW.VALUE));\n    ELSIF UPDATING THEN\n        INSERT INTO LOG_TABLE (LOG_ID, TABLE_NAME, ROW_ID, OPERATION, CHANGE_DATE, OLD_DATA, NEW_DATA)\n        VALUES (LOG_SEQ.NEXTVAL, 'EXAMPLE_TABLE', :NEW.ID, 'UPDATE', SYSTIMESTAMP, \n                XMLFOREST(:OLD.ID, :OLD.NAME, :OLD.VALUE), XMLFOREST(:NEW.ID, :NEW.NAME, :NEW.VALUE));\n    ELSIF DELETING THEN\n        INSERT INTO LOG_TABLE (LOG_ID, TABLE_NAME, ROW_ID, OPERATION, CHANGE_DATE, OLD_DATA)\n        VALUES (LOG_SEQ.NEXTVAL, 'EXAMPLE_TABLE', :OLD.ID, 'DELETE', SYSTIMESTAMP, XMLFOREST(:OLD.ID, :OLD.NAME, :OLD.VALUE));\n    END IF;\nEND;\n/