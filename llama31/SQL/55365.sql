DECLARE\n  TYPE bind_array IS TABLE OF NUMBER;\n  binds bind_array;\n  sql_stmt VARCHAR2(100);\nBEGIN\n  -- dynamically build the binds array\n  binds := bind_array();\n  FOR i IN 1..2 LOOP\n    binds.EXTEND;\n    binds(i) := 1;\n  END LOOP;\n\n  sql_stmt := 'SELECT SYSDATE FROM DUAL WHERE :var1 = :var2';\n\n  EXECUTE IMMEDIATE sql_stmt USING binds;\nEND;