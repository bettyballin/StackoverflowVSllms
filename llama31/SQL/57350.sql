CREATE PROCEDURE MyProcedure\nAS\nBEGIN\n    BEGIN TRY\n        OPEN SYMMETRIC KEY MySymmetricKey DECRYPTION BY CERTIFICATE MyCertificate;\n        -- Execute T-SQL statements\n    END TRY\n    BEGIN CATCH\n        CLOSE SYMMETRIC KEY MySymmetricKey;\n        DECLARE @ErrorMessage nvarchar(4000);\n        SET @ErrorMessage = ERROR_MESSAGE();\n        RAISERROR (@ErrorMessage, 16, 1);\n    END CATCH\n    CLOSE SYMMETRIC KEY MySymmetricKey;\nEND