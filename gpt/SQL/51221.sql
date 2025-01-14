DECLARE\n    CURSOR c IS \n        SELECT column1, column2, column3  -- List all columns except BLOB\n        FROM FOO;\n    record c%ROWTYPE;\nBEGIN\n    OPEN c;\n    LOOP\n        FETCH c INTO record;\n        EXIT WHEN c%NOTFOUND;\n        -- Process the record here\n        DBMS_OUTPUT.PUT_LINE(record.column1 || ', ' || record.column2 || ', ' || record.column3);\n    END LOOP;\n    CLOSE c;\nEND;\n/