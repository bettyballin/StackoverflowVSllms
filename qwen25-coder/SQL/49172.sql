-- Step 1: Lock the rows in TEST_P for update and compute the changes\nWITH Changes AS (\n    SELECT SRC AS WHO, SUM(AMT) AMT FROM TEST_P WHERE B_ID_SRC IS NULL AND B_ID_DEST IS NULL GROUP BY SRC FOR UPDATE\n    UNION ALL\n    SELECT DEST AS WHO, -SUM(AMT) AMT FROM TEST_P WHERE B_ID_SRC IS NULL AND B_ID_DEST IS NULL GROUP BY DEST FOR UPDATE\n),\n-- Step 2: Insert computed changes into TEST_B and generate IDs in a single step\nInsertedRows AS (\n    INSERT INTO TEST_B (ID, BATCH, WHO, AMT)\n    SELECT TEST_B_SEQ.NEXTVAL, 42, WHO, AMT FROM Changes\n    RETURNING *\n)\n-- Step 3: Update TEST_P with the generated IDs from TEST_B\nUPDATE TEST_P\nSET B_ID_SRC = IR1.ID,\n    B_ID_DEST = IR2.ID\nFROM InsertedRows IR1, InsertedRows IR2\nWHERE (TEST_P.SRC = IR1.WHO AND IR1.AMT > 0)\nAND (TEST_P.DEST = IR2.WHO AND IR2.AMT < 0);