CREATE TABLE AuditTrail (\n    AuditID INT PRIMARY KEY IDENTITY(1,1),\n    TableName NVARCHAR(255),\n    RecordID INT,\n    FieldName NVARCHAR(255),\n    OldValue NVARCHAR(MAX),\n    NewValue NVARCHAR(MAX),\n    ModifiedBy NVARCHAR(255),\n    ModifiedAt DATETIME DEFAULT GETDATE()\n);