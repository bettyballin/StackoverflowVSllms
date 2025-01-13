-- Surrogate Key Tables\nCREATE TABLE PartSurrogate (\n    PartID INT IDENTITY(1,1) PRIMARY KEY,\n    PartNumber NVARCHAR(50) NOT NULL,\n    UNIQUE (PartNumber)\n);\n\nCREATE TABLE Plant (\n    PlantID INT IDENTITY(1,1) PRIMARY KEY\n);\n\nCREATE TABLE Engineer (\n    EngineerID INT IDENTITY(1,1) PRIMARY KEY\n);\n\nCREATE TABLE PartPlantEngineerSurrogate (\n    PPEID INT IDENTITY(1,1) PRIMARY KEY,\n    PartID INT,\n    PlantID INT,\n    EngineerID INT,\n    FOREIGN KEY (PartID) REFERENCES PartSurrogate(PartID),\n    FOREIGN KEY (PlantID) REFERENCES Plant(PlantID),\n    FOREIGN KEY (EngineerID) REFERENCES Engineer(EngineerID)\n);\n\n-- Natural Key Tables\nCREATE TABLE PartNatural (\n    PartNumber NVARCHAR(50) PRIMARY KEY\n);\n\nCREATE TABLE PartPlantEngineerNatural (\n    PartNumber NVARCHAR(50),\n    PlantID INT,\n    EngineerID INT,\n    PRIMARY KEY (PartNumber, PlantID, EngineerID),\n    FOREIGN KEY (PartNumber) REFERENCES PartNatural(PartNumber),\n    FOREIGN KEY (PlantID) REFERENCES Plant(PlantID),\n    FOREIGN KEY (EngineerID) REFERENCES Engineer(EngineerID)\n);