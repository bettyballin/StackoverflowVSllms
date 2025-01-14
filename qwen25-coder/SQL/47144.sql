DECLARE \n  name      VARCHAR2(30);\n  code      VARCHAR(10);\n  col_val   VARCHAR2(30);\n  col2_val  NUMBER;\nBEGIN\n  name := 'test';\n  code := '909'; -- Change this to your desired test case\n\n  BEGIN\n    SELECT col1, col2 \n      INTO col_val, col2_val \n      FROM t1 \n     WHERE REGEXP_LIKE(col1, '^' || name || '\s+' || code) -- Exact match check\n       AND ROWNUM = 1; -- Ensure only one row is selected\n\n  EXCEPTION \n    WHEN NO_DATA_FOUND THEN \n      SELECT col1, col2 \n        INTO col_val, col2_val \n        FROM t1 \n       WHERE REGEXP_LIKE(col1, '^' || name) -- Fallback to any match with 'name'\n         AND ROWNUM = 1; -- Ensure only one row is selected\n  END;\n\n  DBMS_OUTPUT.PUT_LINE('val:' || col_val || ' id:' || col2_val);\nEND;