CREATE FUNCTION dbo.SplitTextIntoWords (@text nvarchar(max))\nRETURNS @words TABLE (word nvarchar(50))\nAS\nBEGIN\n    DECLARE @word nvarchar(50)\n    DECLARE @pos int\n\n    SET @text = LOWER(@text)\n    SET @pos = 1\n\n    WHILE @pos <= LEN(@text)\n    BEGIN\n        SET @word = ''\n        WHILE @pos <= LEN(@text) AND @text[@pos] LIKE '[a-z0-9]'\n        BEGIN\n            SET @word = @word + SUBSTRING(@text, @pos, 1)\n            SET @pos = @pos + 1\n        END\n        IF @word <> ''\n            INSERT INTO @words (word) VALUES (@word)\n        SET @pos = @pos + 1\n    END\n\n    RETURN\nEND