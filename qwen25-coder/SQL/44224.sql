CREATE TABLE Entities (\n    EntityID INT PRIMARY KEY AUTO_INCREMENT,\n    -- other necessary columns for the entity\n);\n\nCREATE TABLE Fields (\n    FieldID INT PRIMARY KEY AUTO_INCREMENT,\n    FieldType ENUM('string', 'number') NOT NULL,  -- Extend as needed\n    FieldName VARCHAR(255) NOT NULL UNIQUE        -- Unique field name\n);\n\nCREATE TABLE FieldValues (\n    EntityID INT,\n    FieldID INT,\n    Value TEXT,  -- Use appropriate data type based onFieldType\n    PRIMARY KEY (EntityID, FieldID),\n    FOREIGN KEY (EntityID) REFERENCES Entities(EntityID),\n    FOREIGN KEY (FieldID) REFERENCES Fields(FieldID)\n);