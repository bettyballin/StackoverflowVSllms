DELETE FROM YourTableName\n   WHERE PrimaryKeyField = TroubleRowID;\n\n   INSERT INTO YourTableName (column1, column2, column3, column4)\n   SELECT * FROM #TempTable;