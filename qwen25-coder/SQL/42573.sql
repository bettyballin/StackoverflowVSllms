-- Step 1: Drop all non-clustered indexes\nALTER TABLE YourTableName DROP INDEX index_name1;\nALTER TABLE YourTableName DROP INDEX index_name2;\n-- Repeat for all indexes\n\n-- Alternatively, use a dynamic SQL if you can list the names easily or from system catalog views\nDECLARE @sql NVARCHAR(MAX) = N'';\nSELECT @sql += 'ALTER TABLE YourTableName DROP INDEX [' + name + ']'\nFROM sys.indexes\nWHERE object_id = OBJECT_ID('YourTableName')\nAND index_id > 0 -- Exclude the heap table (if any)\nEXEC sp_executesql @sql;\n\n-- Step 2: Insert Data in batches\nBULK INSERT YourTableName\nFROM 'path_to_your_data_file.csv'\nWITH (\n    FIELDTERMINATOR = ',',\n    ROWTERMINATOR = '\n',\n    BATCHSIZE = 100000 -- Adjust based on your environment and performance\n);\n\n-- Step 3: Recreate all indexes\n-- You can use the same dynamic SQL approach to recreate as per original definition\nEXEC sp_executesql N'\nCREATE INDEX index_name1 ON YourTableName (column1, column2);\nCREATE INDEX index_name2 ON YourTableName (column3);\n-- Repeat for all indexes';