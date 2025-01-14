CREATE TRIGGER trg_validate_magicvalue\nON MyTable\nINSTEAD OF INSERT, UPDATE\nAS\nBEGIN\n    IF EXISTS (\n        SELECT 1\n        FROM inserted\n        WHERE magicvalue <= 0 OR magicvalue >= 100\n    )\n    BEGIN\n        RAISERROR ('magicvalue must be between 1 and 99.', 16, 1);\n        ROLLBACK TRANSACTION;\n        RETURN;\n    END\n\n    -- If validation passes, perform the insert or update\n    IF EXISTS (SELECT * FROM inserted)\n    BEGIN\n        INSERT INTO MyTable (name, magicvalue)\n        SELECT name, magicvalue\n        FROM inserted;\n    END\n\n    IF EXISTS (SELECT * FROM deleted)\n    BEGIN\n        UPDATE MyTable\n        SET name = i.name, magicvalue = i.magicvalue\n        FROM inserted i\n        WHERE MyTable.id = i.id;\n    END\nEND;