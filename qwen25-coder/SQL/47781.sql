-- Contacts Table\nCREATE TABLE Contacts (\n    Id INT PRIMARY KEY,\n    FirstName NVARCHAR(50),\n    LastName NVARCHAR(50),\n    -- other contact details fields\n);\n\n-- PhoneNumbers Table\nCREATE TABLE PhoneNumbers (\n    Id INT PRIMARY KEY,\n    ContactId INT FOREIGN KEY REFERENCES Contacts(Id),\n    PhoneNumber NVARCHAR(22),\n    Description NVARCHAR(100)\n);