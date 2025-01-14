CREATE PROCEDURE GetItemDetails\n    @itemNumber INT,\n    @ItemType CHAR(1)\nAS\nBEGIN\n    DECLARE @SQL NVARCHAR(MAX);\n\n    SET @SQL = N'\n        SELECT ItemNumber, ItemType, Description\n        FROM ' + \n        CASE \n            WHEN @ItemType = 'A' THEN N'TableA WHERE ItemNumber'\n            ELSE N'TableB WHERE PartNumber'\n        END + N' = @itemNumberParam';\n\n    EXEC sp_executesql @SQL, N'@itemNumberParam INT', @itemNumber;\nEND;