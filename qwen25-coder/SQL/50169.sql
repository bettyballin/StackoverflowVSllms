CREATE TRIGGER table_name_trigger\nON table_name\nAFTER INSERT, UPDATE, DELETE\nAS\nBEGIN\n    IF EXISTS(SELECT 1 FROM inserted) AND EXISTS(SELECT 1 FROM deleted)\n        -- This condition is true for an update.\n        PRINT 'Update operation occurred.'\n    ELSE IF EXISTS(SELECT 1 FROM inserted)\n        -- Only the inserted table will have rows for insert operations.\n        PRINT 'Insert operation occurred.'\n    ELSE IF EXISTS(SELECT 1 FROM deleted)\n        -- Only the deleted table will have rows for delete operations.\n        PRINT 'Delete operation occurred.'\nEND