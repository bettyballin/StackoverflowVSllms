DECLARE @sql NVARCHAR(MAX)\nDECLARE @ids TABLE (id INT)\n\n-- Insert your IDs here, or select them from other tables as necessary\nINSERT INTO @ids (id) VALUES (2), (3)\n\n-- Initialize the dynamic SQL statement\nSET @sql = N'SELECT * FROM Subs(' + CAST((SELECT TOP 1 id FROM @ids) AS NVARCHAR(10)) + ')'\n\n-- Append UNION SELECT statements for each additional ID\nDECLARE @currentId INT, @first BIT = 0\nWHILE EXISTS (SELECT * FROM @ids WHERE processed = 0)\nBEGIN\n    SELECT TOP 1 @currentId = id FROM @ids WHERE processed = 0\n\n    IF @first = 0\n        SET @first = 1\n    ELSE\n        SET @sql += N' UNION '\n\n    -- Use QUOTENAME to safely handle any unexpected input or delimiters in IDs\n    SET @sql += N'SELECT * FROM Subs(' + CAST(@currentId AS NVARCHAR(10)) + ')'\n\n    UPDATE @ids SET processed = 1 WHERE id = @currentId\nEND\n\n-- Execute the dynamic SQL string\nEXEC sp_executesql @sql