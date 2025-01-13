DECLARE\n  TYPE bind_array IS TABLE OF NUMBER;\n  binds bind_array := bind_array(1, 1);\n  sql_stmt VARCHAR2(100) := 'SELECT SYSDATE FROM DUAL WHERE :var1 = :var2';\nBEGIN\n  EXECUTE IMMEDIATE sql_stmt USING binds;\nEND;