CREATE TABLE Dim_Person (\n    PersonSK INT IDENTITY(1,1) PRIMARY KEY,\n    PersonID INT NOT NULL UNIQUE,\n    Gender NVARCHAR(10),\n    BirthDate DATE\n);