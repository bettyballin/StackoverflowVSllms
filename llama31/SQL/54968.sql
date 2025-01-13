ALTER FUNCTION uf_AlphaNumericIncrement\n(\n    @ID VARCHAR(10)\n)\nRETURNS VARCHAR(10) AS\nBEGIN\n    DECLARE @RES VARCHAR(10) = @ID;\n    DECLARE @LEN INT = LEN(@ID);\n    DECLARE @POS INT = @LEN;\n    DECLARE @CARRY BIT = 0;\n\n    WHILE @POS > 0 AND (@CARRY = 1 OR SUBSTRING(@RES, @POS, 1) = '9')\n    BEGIN\n        IF SUBSTRING(@RES, @POS, 1) = '9'\n        BEGIN\n            SET @RES = STUFF(@RES, @POS, 1, '0');\n            SET @CARRY = 1;\n        END\n        ELSE IF @CARRY = 1\n        BEGIN\n            SET @RES = STUFF(@RES, @POS, 1, CAST(CAST(SUBSTRING(@RES, @POS, 1) AS SMALLINT) + 1 AS VARCHAR(10)));\n            SET @CARRY = 0;\n        END\n\n        SET @POS = @POS - 1;\n    END\n\n    IF @CARRY = 1 AND @POS = 0\n    BEGIN\n        SET @RES = '1' + @RES;\n    END\n\n    RETURN @RES;\nEND