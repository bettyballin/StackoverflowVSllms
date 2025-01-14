-- Using INT for ID\nCREATE TABLE Users (\n    UserID INT IDENTITY(1,1) PRIMARY KEY,\n    UserName NVARCHAR(255) NOT NULL\n);\n\n-- Using UNIQUEIDENTIFIER (GUID) for ID\nCREATE TABLE Products (\n    ProductID UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID() PRIMARY KEY,\n    ProductName NVARCHAR(255) NOT NULL\n);