CREATE TABLE UserMapping (\n    UserID INT IDENTITY(1,1) PRIMARY KEY,\n    ObjectGUID UNIQUEIDENTIFIER NOT NULL,\n    UserInitials NVARCHAR(10) -- Optional: for reference\n);