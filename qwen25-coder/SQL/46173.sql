CREATE TABLE DimCase (\n         CaseID INT PRIMARY KEY,\n         CaseName VARCHAR(100),\n         ClientID INT,  -- can map to clients dimension if needed\n         EntryDate DATE,\n          -- other relevant case attributes\n         FOREIGN KEY (ClientID) REFERENCES DimClient(ClientID)\n     );