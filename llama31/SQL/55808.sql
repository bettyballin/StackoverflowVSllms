CREATE OR REPLACE TRIGGER birth_date_trg\nBEFORE INSERT OR UPDATE ON your_table\nFOR EACH ROW\nBEGIN\n  IF :NEW.BIRTH_DATE NOT BETWEEN (SYSDATE - 100 * 365.25) AND (SYSDATE + 1) THEN\n    RAISE_APPLICATION_ERROR(-20001, 'Birth date is out of valid range');\n  END IF;\nEND;\n/