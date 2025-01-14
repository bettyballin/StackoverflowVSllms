CREATE TRIGGER trg_myData_InsertUpdate\nON myData\nINSTEAD OF INSERT, UPDATE\nAS\nBEGIN\n    -- Check for overlapping periods\n    IF EXISTS (\n        SELECT 1\n        FROM inserted i\n        JOIN myData m ON i.fk_item_id = m.fk_item_id AND\n            m.id <> i.id AND -- Ensure we're not checking against itself in updates\n            i.valid_from < m.invlaid_from AND\n            i.invlaid_from > m.valid_from\n    )\n    BEGIN\n        RAISERROR ('Overlapping date ranges are not allowed for the same fk_item_id.', 16, 1);\n        ROLLBACK TRANSACTION;\n        RETURN;\n    END\n\n    -- If no conflicts, proceed with the insert or update\n    INSERT INTO myData (fk_item_id, valid_from, invlaid_from)\n    SELECT fk_item_id, valid_from, invlaid_from\n    FROM inserted\n    WHERE NOT EXISTS (\n        SELECT 1\n        FROM myData m\n        WHERE m.fk_item_id = inserted.fk_item_id AND\n              m.id <> inserted.id AND -- Ensure we're not checking against itself in updates\n              inserted.valid_from < m.invlaid_from AND\n              inserted.invlaid_from > m.valid_from\n    );\nEND;