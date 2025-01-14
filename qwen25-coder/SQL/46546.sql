CREATE TABLE Users (\n    UserID INT IDENTITY(1,1) PRIMARY KEY, -- Using int for primary key\n    UserName NVARCHAR(50) NOT NULL UNIQUE,\n    Email NVARCHAR(100) NOT NULL UNIQUE\n);\n\nCREATE TABLE Orders (\n    OrderID INT IDENTITY(1,1) PRIMARY KEY,\n    UserID INT FOREIGN KEY REFERENCES Users(UserID), -- Foreign key referencing user table\n    OrderDate DATETIME NOT NULL\n);