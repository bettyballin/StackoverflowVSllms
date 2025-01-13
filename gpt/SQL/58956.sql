CREATE TRIGGER PreventDeletion\nON YourTable\nINSTEAD OF DELETE\nAS\nBEGIN\n    IF EXISTS (SELECT * FROM deleted WHERE id IN (0, 1, 2))\n    BEGIN\n        -- If any rows with id 0, 1, or 2 are being deleted, raise an error\n        RAISERROR('Deletion of rows with id 0, 1, or 2 is not allowed.', 16, 1);\n        ROLLBACK TRANSACTION;\n    END\n    ELSE\n    BEGIN\n        -- If no rows with id 0, 1, or 2 are being deleted, proceed with the deletion\n        DELETE FROM YourTable\n        WHERE id IN (SELECT id FROM deleted);\n    END\nEND;