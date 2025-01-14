DECLARE\n  l_clob CLOB;\nBEGIN\n  FOR rec IN (SELECT deptno, ename\n              FROM wd_emp\n              ORDER BY deptno, empno) LOOP\n    IF DBMS_LOB.GETLENGTH(l_clob) = 0 THEN\n      DBMS_LOB.CREATETEMPORARY(l_clob, TRUE);\n    ELSE\n      DBMS_LOB.WRITEAPPEND(l_clob, LENGTH(','), ',');\n    END IF;\n    DBMS_LOB.WRITEAPPEND(l_clob, LENGTH(rec.ename), rec.ename);\n  END LOOP;\n\n  -- Output or process the CLOB as needed\n  -- For demonstration purposes, you can write it to a table or handle it in your Java code.\n  INSERT INTO temp_output (deptno, clob_data)\n  VALUES (rec.deptno, l_clob);\n\n  DBMS_LOB.FREETEMPORARY(l_clob);\nEND;\n/\n\n-- Example table to store the result\nCREATE TABLE temp_output (\n  deptno NUMBER,\n  clob_data CLOB\n);