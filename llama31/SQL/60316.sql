CREATE FUNCTION dbo.IsUniqueNameWithinParent (@Name nvarchar(512), @ParentId int)\nRETURNS bit\nAS\nBEGIN\n    DECLARE @Count int;\n    SELECT @Count = COUNT(*) \n    FROM MyTable \n    WHERE Name = @Name AND ParentId = @ParentId;\n    RETURN CASE WHEN @Count = 0 THEN 1 ELSE 0 END;\nEND\nGO\n\nALTER TABLE MyTable\nADD CONSTRAINT CHK_UniqueNameWithinParent \nCHECK (dbo.IsUniqueNameWithinParent(Name, ParentId) = 1);