CREATE TABLE AuditLog (\n    AuditID INT IDENTITY(1,1) PRIMARY KEY,\n    TableName VARCHAR(50),\n    RecordID INT,\n    BeforeData XML,\n    AfterData XML,\n    ChangedBy VARCHAR(50),\n    ChangedDate DATETIME\n);\n\nCREATE TRIGGER trg_AuditTable ON YourTable\nAFTER INSERT, UPDATE, DELETE\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    INSERT INTO AuditLog (TableName, RecordID, BeforeData, AfterData, ChangedBy, ChangedDate)\n    SELECT 'YourTable', i.RecordID, \n           (SELECT * FROM deleted FOR XML RAW), \n           (SELECT * FROM inserted FOR XML RAW), \n           SUSER_NAME(), GETDATE()\n    FROM inserted i\n    INNER JOIN deleted d ON i.RecordID = d.RecordID;\nEND;