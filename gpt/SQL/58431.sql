INSERT INTO DestinationDatabase.dbo.Table2 (column1, column2, ...)\nSELECT column1, column2, ...\nFROM SourceServerName.SourceDatabase.dbo.Table1\nWHERE rule1 = true;