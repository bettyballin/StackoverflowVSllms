CREATE OR REPLACE TRIGGER my_table_before_insert_trigger\n   BEFORE INSERT ON my_table\n   FOR EACH ROW\n   BEGIN\n       SELECT my_table_seq.NEXTVAL INTO :NEW.id FROM dual;\n   END;