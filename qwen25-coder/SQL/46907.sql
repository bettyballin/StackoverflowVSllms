-- Insert data from TempDB_Restore to your main database\n   INSERT INTO YourMainDatabase.YourSchema.YourTable (Column1, Column2)\n   SELECT Column1, Column2 FROM TempDB_Restore.YourSchema.YourTable;\n   GO