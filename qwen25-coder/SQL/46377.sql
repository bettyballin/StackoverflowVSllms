CREATE TABLE ColorComposition (\n       Id INT PRIMARY KEY IDENTITY(1,1),\n       MotherColorId INT NOT NULL,\n       ChildColorId INT NOT NULL,\n       CONSTRAINT FK_ColorComposition_MotherColorId FOREIGN KEY (MotherColorId) REFERENCES Colors(Id),\n       CONSTRAINT FK_ColorComposition_ChildColorId FOREIGN KEY (ChildColorId) REFERENCES Colors(Id)\n   );