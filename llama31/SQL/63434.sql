CREATE TABLE ParentTable (\n    ParentId INT PRIMARY KEY,\n    HasChildren BIT DEFAULT 0\n)\n\nCREATE TABLE ChildTable (\n    ChildId INT PRIMARY KEY,\n    ParentId INT,\n    CONSTRAINT FK_Parent FOREIGN KEY (ParentId) REFERENCES ParentTable(ParentId)\n)\n\nCREATE TRIGGER TRG_UpdateParent ON ChildTable FOR INSERT, DELETE\nAS\nBEGIN\n    IF EXISTS (SELECT 1 FROM inserted)\n        UPDATE p SET HasChildren = 1\n        FROM ParentTable p\n        WHERE p.ParentId IN (SELECT ParentId FROM inserted)\n    ELSE IF EXISTS (SELECT 1 FROM deleted)\n        UPDATE p SET HasChildren = CASE WHEN EXISTS (SELECT 1 FROM ChildTable c WHERE c.ParentId = p.ParentId) THEN 1 ELSE 0 END\n        FROM ParentTable p\n        WHERE p.ParentId IN (SELECT ParentId FROM deleted)\nEND