CREATE PROC dbo.spGetData\n@code AS CHAR(4)\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    BEGIN TRY\n        IF (@code = 'aaaa')\n            SELECT date FROM [ServerA].Stock.dbo.Syspara;\n        ELSE IF (@code = 'bbbb')\n            SELECT date FROM [ServerB].Stock.dbo.Syspara;\n        ELSE IF (@code = 'cccc')\n            SELECT date FROM [ServerC].Stock.dbo.Syspara;\n        ELSE IF (@code = 'dddd')\n            SELECT date FROM [ServerD].Stock.dbo.Syspara;\n        ELSE\n            RAISERROR('Invalid code provided', 16, 1);\n    END TRY\n    BEGIN CATCH\n        -- Handle the error\n        PRINT 'An error occurred.';\n        PRINT ERROR_MESSAGE();\n    END CATCH\nEND;\nGO