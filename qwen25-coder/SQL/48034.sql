CREATE TABLE Users (\n    UserID UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,\n    Username NVARCHAR(50) NOT NULL\n);