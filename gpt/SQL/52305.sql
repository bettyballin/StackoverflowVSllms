-- Step 1: Create the table to hold the unique IDs\nCREATE TABLE UniqueObjectIDs (\n    ID INT PRIMARY KEY\n);\n\n-- Step 2: Create a stored procedure to refresh the data\nCREATE PROCEDURE RefreshUniqueObjectIDs\nAS\nBEGIN\n    TRUNCATE TABLE UniqueObjectIDs;\n\n    INSERT INTO UniqueObjectIDs (ID)\n    SELECT ID FROM Table1\n    UNION\n    SELECT ID FROM Table2\n    UNION\n    SELECT ID FROM Table3;\nEND;\n\n-- Step 3: Schedule a SQL Server Agent job to run the stored procedure periodically