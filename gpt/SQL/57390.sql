CREATE TABLE EntityType (\n    EntityTypeID INT PRIMARY KEY,\n    EntityTypeName VARCHAR(50)\n);\n\nCREATE TABLE Entity (\n    EntityID INT PRIMARY KEY,\n    EntityTypeID INT,\n    OriginID INT,\n    FOREIGN KEY (EntityTypeID) REFERENCES EntityType(EntityTypeID)\n);\n\nCREATE TABLE Company (\n    CompanyID INT PRIMARY KEY,\n    CompanyName VARCHAR(100),\n    FOREIGN KEY (CompanyID) REFERENCES Entity(OriginID)\n);\n\nCREATE TABLE Employee (\n    EmployeeID INT PRIMARY KEY,\n    FirstName VARCHAR(50),\n    FOREIGN KEY (EmployeeID) REFERENCES Entity(OriginID)\n);\n\nCREATE TABLE AddressType (\n    AddressTypeID INT PRIMARY KEY,\n    AddressTypeName VARCHAR(50)\n);\n\nCREATE TABLE Address (\n    AddressID INT PRIMARY KEY,\n    AddressTypeID INT,\n    EntityID INT,\n    StreetAddress1 VARCHAR(100),\n    FOREIGN KEY (AddressTypeID) REFERENCES AddressType(AddressTypeID),\n    FOREIGN KEY (EntityID) REFERENCES Entity(EntityID)\n);