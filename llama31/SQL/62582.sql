CREATE PROCEDURE MyProcedure\n    @myList nvarchar(50)\nAS\nBEGIN\n    SELECT *\n    FROM tbl\n    WHERE Id IN (SELECT id FROM dbo.Split(@myList, ','))\nEND