-- Example of a large batch update in SQL Server\nBEGIN TRANSACTION;\nUPDATE YourTargetTable\nSET Column1 = SourceTable.Column1,\n    Column2 = SourceTable.Column2\nFROM YourTargetTable\nJOIN SourceTable ON YourTargetTable.PrimaryKeyColumn = SourceTable.PrimaryKeyColumn\nWHERE ...\nCOMMIT TRANSACTION;