CREATE OR REPLACE FUNCTION MY_FUNCTION (myChar IN CHAR) RETURN INTEGER AS\n  TYPE ref_cur IS REF CURSOR;\n  cur ref_cur;\nBEGIN\n  IF myChar = 'A' THEN\n    OPEN cur FOR SELECT FIRST_NAME FROM EMPLOYEES;\n  ELSIF myChar = 'B' THEN\n    OPEN cur FOR SELECT LAST_NAME FROM EMPLOYEES;\n  END IF;\n\n  LOOP\n    FETCH cur INTO X;\n    EXIT WHEN cur%NOTFOUND;\n    -- DO STUFF\n  END LOOP;\n  CLOSE cur;\n  RETURN 1;\nEND MY_FUNCTION;