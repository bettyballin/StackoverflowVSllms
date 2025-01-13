CREATE FUNCTION dbo.DecimalToBase32 (@decimalValue BIGINT)\nRETURNS VARCHAR(255)\nAS\nBEGIN\n    DECLARE @base32Chars VARCHAR(32) = '0123456789ABCDEFGHJKMNPQRSTVWXYZ'\n    DECLARE @base32Value VARCHAR(255) = ''\n    DECLARE @remainder BIGINT\n\n    IF @decimalValue = 0\n    BEGIN\n        RETURN '0'\n    END\n\n    WHILE @decimalValue > 0\n    BEGIN\n        SET @remainder = @decimalValue % 32\n        SET @base32Value = SUBSTRING(@base32Chars, @remainder + 1, 1) + @base32Value\n        SET @decimalValue = @decimalValue / 32\n    END\n\n    RETURN @base32Value\nEND