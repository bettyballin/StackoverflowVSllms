CREATE TABLE Users (\n    UserID INT PRIMARY KEY,\n    Username NVARCHAR(50) NOT NULL,\n    Email NVARCHAR(100) NOT NULL,\n    DateRegistered DATETIME NOT NULL DEFAULT GETDATE(),\n    IsActive BIT NOT NULL DEFAULT 1\n);