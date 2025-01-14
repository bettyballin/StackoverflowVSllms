CREATE TABLE UserEntries (\n       EntryID INT IDENTITY(1,1) PRIMARY KEY,\n       UserID INT NOT NULL,\n       EntryNumber INT NOT NULL,\n       Value NVARCHAR(MAX),\n       CreatedAt DATETIME DEFAULT GETDATE()\n   );