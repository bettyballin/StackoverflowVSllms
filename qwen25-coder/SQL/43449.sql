-- Step 1: Create new table with the column structure you want\nCREATE TABLE NewTableName (\n    NewColumn INT, -- The new column at the beginning\n    Column1 INT,\n    Column2 VARCHAR(50),\n    -- Add other columns here as required\n);\n\n-- Step 2: Copy data from old table to new table\nINSERT INTO NewTableName (NewColumn, Column1, Column2)\nSELECT NULL AS NewColumn, Column1, Column2\nFROM OldTableName;\n\n-- Step 3: Drop the original table\nDROP TABLE OldTableName;\n\n-- Step 4: Rename the new table to the original name\nEXEC sp_rename 'NewTableName', 'OldTableName';