BEGIN\n  -- Lock the rows in TEST_P with the correct status\n  FOR rec IN (\n    SELECT SRC, DEST, SUM(AMT) AS AMT\n    FROM TEST_P\n    WHERE B_ID_SRC IS NULL AND B_ID_DEST IS NULL\n    FOR UPDATE\n  ) LOOP\n    -- Insert records into TEST_B for SRC\n    INSERT INTO TEST_B (ID, BATCH, WHO, AMT)\n    VALUES (TEST_B_SEQ.NEXTVAL, 42, rec.SRC, rec.AMT);\n    \n    -- Insert records into TEST_B for DEST with negative amount\n    INSERT INTO TEST_B (ID, BATCH, WHO, AMT)\n    VALUES (TEST_B_SEQ.NEXTVAL, 42, rec.DEST, -rec.AMT);\n  END LOOP;\nEND;\n/