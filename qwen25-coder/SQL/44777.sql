CREATE FUNCTION dbo.SplitString \n(\n    @List NVARCHAR(MAX),\n    @Delimiter CHAR(1)\n)\nRETURNS @TableOfValues TABLE (Value INT) AS\nBEGIN\n    DECLARE @Xml AS XML;\n    SET @Xml = CAST('<T>' + REPLACE(@List, @Delimiter, '</T><T>') + '</T>' AS XML);\n\n    INSERT INTO @TableOfValues(Value)\n    SELECT T.value('.', 'INT') AS Value\n      FROM @Xml.nodes('/T') AS X(T);\n      \n    RETURN;\nEND;