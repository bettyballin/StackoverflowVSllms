CREATE TABLE DimCase (\n       CaseID INT PRIMARY KEY,\n       CaseName VARCHAR(255),\n       CaseType VARCHAR(50),\n       CaseStatus VARCHAR(50),\n       CreatedDate DATE,\n       -- Additional attributes related to the case\n   );