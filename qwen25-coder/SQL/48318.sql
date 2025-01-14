USE [db_name]\nGO\n\nBEGIN TRY\n    BEGIN TRANSACTION;\n    -- ...TONS OF INSERTS...\n    COMMIT TRANSACTION;\nEND TRY\nBEGIN CATCH\n    -- Handle the error (e.g., log it or take some action)\n    ROLLBACK TRANSACTION;\n    PRINT 'Error in first batch: ' + ERROR_MESSAGE();\n    -- Optionally, do other things like logging the error to a table\nEND CATCH\n\nGO\n\nBEGIN TRY\n    BEGIN TRANSACTION;\n    -- ...TONS OF INSERTS...\n    COMMIT TRANSACTION;\nEND TRY\nBEGIN CATCH\n    ROLLBACK TRANSACTION;\n    PRINT 'Error in second batch: ' + ERROR_MESSAGE();\n    -- Optionally, do other things like logging the error to a table\nEND CATCH\n\nGO\n\n-- Repeat as needed for additional batches