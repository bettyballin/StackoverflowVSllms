CREATE TABLE EmailProcessingLocks (\n    Id INT IDENTITY(1,1) PRIMARY KEY,\n    EmailAddress NVARCHAR(255) NOT NULL UNIQUE,\n    AcquiredAt DATETIME NOT NULL,\n    Processed BIT NOT NULL DEFAULT 0\n);