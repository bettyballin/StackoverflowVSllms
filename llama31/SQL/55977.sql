BEGIN TRANSACTION;\n\nBEGIN TRY\n    -- Modify table schema\n    ALTER TABLE MyTable ADD NewColumn INT;\n    ALTER TABLE MyTable DROP COLUMN OldColumn;\n    -- Other modifications...\n\n    COMMIT TRANSACTION;\nEND TRY\nBEGIN CATCH\n    -- Handle errors\n    ROLLBACK TRANSACTION;\n    DECLARE @ErrorMessage NVARCHAR(4000);\n    SET @ErrorMessage = ERROR_MESSAGE();\n    RAISERROR (@ErrorMessage, 16, 1);\nEND CATCH;