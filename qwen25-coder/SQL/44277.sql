BEGIN TRY\n    INSERT INTO tblProducts (ProductCode, ProductName)\n    VALUES ('12345', 'New Product')\nEND TRY\nBEGIN CATCH\n    DECLARE @ErrorMessage NVARCHAR(4000);\n    DECLARE @ErrorSeverity INT;\n    DECLARE @ErrorState INT;\n\n    SELECT \n        @ErrorMessage = ERROR_MESSAGE(),\n        @ErrorSeverity = ERROR_SEVERITY(),\n        @ErrorState = ERROR_STATE();\n\n    RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);\nEND CATCH