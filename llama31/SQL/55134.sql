CREATE FUNCTION dbo.Split (@String varchar(8000), @Delimiter char(1))\nRETURNS @temptable TABLE (items varchar(8000))\nAS\nBEGIN\n    DECLARE @idx int\n    DECLARE @slice varchar(8000)\n\n    SELECT @idx = 1\n    IF LEN(@String) < 1 OR @String IS NULL RETURN\n\n    WHILE @idx != 0\n    BEGIN\n        SET @idx = CHARINDEX(@Delimiter, @String)\n        IF @idx != 0\n            SET @slice = LEFT(@String, @idx - 1)\n        ELSE\n            SET @slice = @String\n\n        IF (LEN(@slice) > 0)\n            INSERT INTO @temptable (Items) VALUES (@slice)\n\n        SET @String = RIGHT(@String, LEN(@String) - @idx)\n        IF LEN(@String) = 0 BREAK\n    END\n    RETURN\nEND\nGO\n\nCREATE TABLE MyTable (\n    CommaColumn varchar(8000),\n    ValueColumn1 int,\n    ValueColumn2 int\n)\n\nINSERT INTO MyTable (CommaColumn, ValueColumn1, ValueColumn2)\nVALUES ('ABC,123', 1, 2), ('XYZ,789', 2, 3)\n\nSELECT s.items AS SplitValue, t.ValueColumn1, t.ValueColumn2\nFROM MyTable t\nCROSS APPLY dbo.Split(t.CommaColumn, ',') s