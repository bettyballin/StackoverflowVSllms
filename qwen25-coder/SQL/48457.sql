CREATE FUNCTION dbo.IntegerToBinaryString (@Number INT)\nRETURNS VARCHAR(32)\nAS\nBEGIN\n    DECLARE @Result VARCHAR(32) = ''\n    WHILE @Number > 0 OR @Result = ''\n    BEGIN\n        SET @Result = SUBSTRING('01', (@Number % 2) + 1, 1) + @Result\n        SET @Number = @Number / 2\n    END\n    RETURN @Result\nEND