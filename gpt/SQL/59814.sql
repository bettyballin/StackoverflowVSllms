-- Step 1: Identify the existing constraint name\n-- (Replace SCHEMA_NAME, TABLE_NAME, and COLUMN_NAME with your actual schema, table, and column names)\nSELECT CONSTNAME\nFROM SYSCAT.KEYCOLUSE\nWHERE TABSCHEMA = 'SCHEMA_NAME'\n  AND TABNAME = 'TABLE_NAME'\n  AND COLNAME = 'COLUMN_NAME';\n\n-- Step 2: Drop the existing foreign key constraint\n-- (Replace CONSTRAINT_NAME with the actual constraint name found in Step 1)\nALTER TABLE SCHEMA_NAME.TABLE_NAME\nDROP CONSTRAINT CONSTRAINT_NAME;\n\n-- Step 3: Add the new foreign key constraint with ON DELETE CASCADE\n-- (Replace PARENT_TABLE, PARENT_COLUMN, CHILD_TABLE, and CHILD_COLUMN with your actual table and column names)\nALTER TABLE CHILD_TABLE\nADD CONSTRAINT NEW_CONSTRAINT_NAME\nFOREIGN KEY (CHILD_COLUMN)\nREFERENCES PARENT_TABLE (PARENT_COLUMN)\nON DELETE CASCADE;