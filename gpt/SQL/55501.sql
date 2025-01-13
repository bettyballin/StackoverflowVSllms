-- Step 1: Alter the column to set the case-sensitive collation\nALTER TABLE MyTable\nALTER COLUMN MyCol VARCHAR(255) COLLATE SQL_Latin1_General_CP1_CS_AS;\n\n-- Step 2: Add the unique constraint\nALTER TABLE MyTable\nADD CONSTRAINT UK_MyTable_MyUniqueKey UNIQUE NONCLUSTERED (MyCol);