ALTER TABLE YourTable\nADD UniqueValue AS (CASE WHEN YourColumn IS NOT NULL THEN YourColumn ELSE DEFAULT END);\n\nCREATE UNIQUE INDEX UQ_YourColumn ON YourTable(UniqueValue);