CREATE OR REPLACE TRIGGER trg_check_birth_date\nBEFORE INSERT OR UPDATE ON your_table\nFOR EACH ROW\nBEGIN\n  IF :NEW.BIRTH_DATE < SYSDATE - NUMTOYMINTERVAL(100, 'YEAR') \n     OR :NEW.BIRTH_DATE >= SYSDATE + 1 THEN\n    RAISE_APPLICATION_ERROR(-20002, 'Birth date must be between 100 years ago and tomorrow.');\n  END IF;\nEND;\n/