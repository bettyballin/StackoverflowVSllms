CREATE TRIGGER trg_MyTable_InsteadOfUpdate\nON MyTable\nINSTEAD OF UPDATE\nAS\nBEGIN\n    -- Perform actions before the update\n    IF UPDATE(MyColumn)\n    BEGIN\n        -- Check or modify the data as needed\n        IF EXISTS (SELECT 1 FROM inserted WHERE MyColumn = 'invalid value')\n        BEGIN\n            RAISERROR ('Invalid value', 16, 1);\n            ROLLBACK TRANSACTION;\n        END\n    END\n\n    -- Perform the actual update\n    UPDATE m\n    SET m.MyColumn = i.MyColumn\n    FROM MyTable m\n    INNER JOIN inserted i ON m.MyPrimaryKey = i.MyPrimaryKey;\nEND;