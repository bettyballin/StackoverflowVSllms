ALTER TABLE tableNames RENAME TO _tableNames_old;\nCREATE TABLE tableNames (\n    -- Define your columns here; make sure to set the correct types and constraints\n    Name TEXT COLLATE NOCASE,\n    -- Other columns...\n);\nINSERT INTO tableNames (Name, ...) SELECT Name, ... FROM _tableNames_old;\nDROP TABLE _tableNames_old;