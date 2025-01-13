-- Create the new Name table\nCREATE TABLE Name (\n    Id INT IDENTITY(1,1) PRIMARY KEY,\n    NameString NVARCHAR(255) UNIQUE NOT NULL\n);\n\n-- Populate the Name table with unique names from Contacts\nINSERT INTO Name (NameString)\nSELECT DISTINCT Name\nFROM Contacts;\n\n-- Add a new column to Contacts to link to the Name table\nALTER TABLE Contacts\nADD NameId INT NULL;\n\n-- Update Contacts to link to the Name table\nUPDATE c\nSET c.NameId = n.Id\nFROM Contacts c\nINNER JOIN Name n ON c.Name = n.NameString;\n\n-- Drop the original Name column from Contacts\nALTER TABLE Contacts\nDROP COLUMN Name;