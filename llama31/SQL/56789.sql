CREATE TABLE Lookups (\n    Id INT PRIMARY KEY,\n    Name VARCHAR(50),\n    Description VARCHAR(200)\n);\n\nCREATE TABLE ComboBoxOptions (\n    Id INT PRIMARY KEY,\n    LookupId INT,\n    OptionText VARCHAR(50),\n    FOREIGN KEY (LookupId) REFERENCES Lookups(Id)\n);