CREATE TABLE Attributes (\n  AttributeID INT PRIMARY KEY,\n  Name NVARCHAR(50) NOT NULL\n);\n\nINSERT INTO Attributes (AttributeID, Name)\nVALUES (1, 'Department'),\n       (2, 'Role'),\n       (3, 'Location');