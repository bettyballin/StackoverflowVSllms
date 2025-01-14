CREATE FUNCTION properCase(@texto VARCHAR(8000)) \nRETURNS VARCHAR(8000) \nAS   \nBEGIN   \n    -- Convert all characters to lower case\n    SET @texto = LOWER(@texto);   \n\n    DECLARE @i INT;   \n    SET @i = ASCII('a');   \n\n    WHILE @i <= ASCII('z')   \n    BEGIN   \n        -- Replace each lowercase letter preceded by a space with its uppercase counterpart\n        SET @texto = REPLACE(@texto, ' ' + CHAR(@i), ' ' + CHAR(@i-32));   \n        SET @i = @i + 1;   \n    END   \n\n    -- Capitalize the first character of the string\n    SET @texto = CHAR(ASCII(LEFT(@texto, 1))-32) + RIGHT(@texto, LEN(@texto)-1);   \n\n    RETURN @texto;   \nEND;