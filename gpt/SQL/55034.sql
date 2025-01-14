-- Step 1: Add the new column to the end of the table\nALTER TABLE MyTable\nADD ColX int NOT NULL DEFAULT 0;\n\n-- Step 2: Drop the existing primary key constraint\nALTER TABLE MyTable\nDROP CONSTRAINT PK_MyTable;\n\n-- Step 3: Add the new primary key constraint including the new column\nALTER TABLE MyTable\nADD CONSTRAINT PK_MyTable PRIMARY KEY (ColA, ColB, ColX, ColC);