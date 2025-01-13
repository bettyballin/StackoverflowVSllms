DECLARE @counter int;\nSET @counter = 1;\n\nDECLARE @tempID varchar(50);\nSET @tempID = '';\n\nDECLARE @tempCat varchar(255);\nSET @tempCat = '';\n\nDECLARE @tempCatString varchar(5000);\nSET @tempCatString = '';\n\nDECLARE @tempCount int;\n-- Assuming @tempCount is set somewhere before the loop starts.\n-- For example, it could be set like this:\n-- SELECT @tempCount = COUNT(*) FROM #vals;\n\nWHILE @counter <= @tempCount\nBEGIN\n    SET @tempID = (\n    SELECT [Val]\n    FROM #vals\n    WHERE [ID] = @counter);\n\n    SET @tempCat = (SELECT [Description] FROM [Categories] WHERE [ID] = @tempID);\n    PRINT @tempCat;\n\n    SET @tempCatString = ISNULL(@tempCatString, '') + '<br/>' + ISNULL(@tempCat, '');\n    SET @counter = @counter + 1;\nEND\n\n-- Output the final concatenated string\nPRINT @tempCatString;