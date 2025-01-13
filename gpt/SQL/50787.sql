-- Document table\nCREATE TABLE Document (\n    ID INT PRIMARY KEY,\n    Title VARCHAR(255)\n);\n\n-- Category table\nCREATE TABLE Category (\n    ID INT PRIMARY KEY,\n    Title VARCHAR(255)\n);\n\n-- Associative table for the many-to-many relationship\nCREATE TABLE Document_Category (\n    DocumentID INT,\n    CategoryID INT,\n    PRIMARY KEY (DocumentID, CategoryID),\n    FOREIGN KEY (DocumentID) REFERENCES Document(ID),\n    FOREIGN KEY (CategoryID) REFERENCES Category(ID)\n);\n\n-- Sample query to get all Documents for a specific Category\nSELECT d.*\nFROM Document d\nJOIN Document_Category dc ON d.ID = dc.DocumentID\nWHERE dc.CategoryID = @targetCategoryID;