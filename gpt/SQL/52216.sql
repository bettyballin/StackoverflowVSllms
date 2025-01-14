CREATE TABLE Certifications (\n    CertificationID INT PRIMARY KEY IDENTITY(1,1),\n    PersonID INT,\n    CertificationName NVARCHAR(255),\n    CertificationDate DATE,\n    CertificationPDF VARBINARY(MAX),\n    FOREIGN KEY (PersonID) REFERENCES People(PersonID)\n);\n\nCREATE TABLE People (\n    PersonID INT PRIMARY KEY IDENTITY(1,1),\n    FirstName NVARCHAR(100),\n    LastName NVARCHAR(100)\n);