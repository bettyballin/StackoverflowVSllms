CREATE FUNCTION dbo.MySqlPasswordHash (@in varchar(64))\nRETURNS char(41)\nAS \nBEGIN\n    DECLARE @first_hash varbinary(20), @second_hash varbinary(20);\n    \n    -- First SHA-1 hash\n    SET @first_hash = HASHBYTES('SHA1', @in);\n    \n    -- Second SHA-1 hash of the first hash, then convert to hex string and hash again\n    DECLARE @hex_first_hash char(40) = LOWER(CONVERT(varchar(64), @first_hash, 2));\n    SET @second_hash = HASHBYTES('SHA1', @hex_first_hash);\n    \n    -- Convert final hashed value to a 41-character string prefixed with '*'\n    RETURN '*' + RIGHT('0' + CONVERT(varchar(40), @second_hash, 2), 40);\nEND\n\n-- Example usage\nSELECT dbo.MySqlPasswordHash('yourPassword');