CREATE TABLE dbo.YourTable_Audit (\n       AuditID INT IDENTITY(1,1) PRIMARY KEY,\n       ChangeType CHAR(1),\n       ChangeDate DATETIME DEFAULT GETDATE(),\n       ChangedBy NVARCHAR(128) DEFAULT ORIGINAL_LOGIN(),\n       -- Original columns from YourTable\n       Column1 DataType1,\n       Column2 DataType2,\n       ...\n       ColumnN DataTypeN\n   );