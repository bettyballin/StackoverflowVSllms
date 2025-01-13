CREATE SEQUENCE my_table_id_seq START WITH 1 INCREMENT BY 1;\nCREATE TRIGGER my_table_id_trg BEFORE INSERT ON my_table FOR EACH ROW\nBEGIN\n  SELECT my_table_id_seq.NEXTVAL INTO :NEW.id FROM DUAL;\nEND;