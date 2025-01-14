-- Step 1: Create tables and metadata table\nCREATE TABLE ImportantTableA (ID INT, Data VARCHAR(100));\nCREATE TABLE ImportantTableB (ID INT, Data VARCHAR(100));\nCREATE TABLE ActiveTable (TableName VARCHAR(50));\nINSERT INTO ActiveTable VALUES ('ImportantTableA');\n\n-- Step 2: Update non-active table\nDECLARE @ActiveTable VARCHAR(50);\nDECLARE @NonActiveTable VARCHAR(50);\n\nSELECT @ActiveTable = TableName FROM ActiveTable;\nSET @NonActiveTable = CASE WHEN @ActiveTable = 'ImportantTableA' THEN 'ImportantTableB' ELSE 'ImportantTableA' END;\n\n-- Example update process\nTRUNCATE TABLE @NonActiveTable;\nINSERT INTO @NonActiveTable (ID, Data)\nSELECT ID, Data FROM SqlFoxProData.ImportantTable;\n\n-- Step 3: Switch active table\nUPDATE ActiveTable SET TableName = @NonActiveTable;\n\n-- Step 4: Website reads\n-- Example read query\nDECLARE @CurrentActiveTable VARCHAR(50);\nSELECT @CurrentActiveTable = TableName FROM ActiveTable;\nEXEC('SELECT * FROM ' + @CurrentActiveTable);