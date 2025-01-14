CREATE TABLE CrystalReports (\n    ReportID INT IDENTITY(1,1) PRIMARY KEY,\n    ReportName NVARCHAR(255) NOT NULL,\n    ReportData VARBINARY(MAX) NOT NULL,\n    VersionNumber INT NOT NULL DEFAULT 1,\n    ModifiedDate DATETIME NOT NULL DEFAULT GETDATE()\n);