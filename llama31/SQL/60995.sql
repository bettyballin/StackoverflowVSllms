CREATE FUNCTION dbo.SplitStrings (@input nvarchar(max))\nRETURNS @output TABLE (value nvarchar(50))\nAS\nBEGIN\n    DECLARE @start int, @end int\n    SELECT @start = 1, @end = CHARINDEX(',', @input)\n    WHILE @start < LEN(@input) + 1 BEGIN\n        IF @end = 0 \n            SET @end = LEN(@input) + 1\n        INSERT INTO @output (value) \n        VALUES(SUBSTRING(@input, @start, @end - @start))\n        SET @start = @end + 1\n        SET @end = CHARINDEX(',', @input, @start)\n    END\n    RETURN\nEND\nGO\n\nDECLARE @input nvarchar(max) = 'Test1,Test2'\nSELECT *\nFROM tblname\nJOIN dbo.SplitStrings(@input) AS s\nON column_name LIKE s.value + '%'