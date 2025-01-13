CREATE TRIGGER trg_MyTable_MagicValue_Validation\nON MyTable\nFOR INSERT, UPDATE\nAS\nBEGIN\n    IF EXISTS (SELECT 1 FROM inserted WHERE magicvalue NOT BETWEEN 1 AND 100)\n    BEGIN\n        RAISERROR ('Invalid magicvalue', 16, 1);\n        ROLLBACK TRANSACTION;\n    END\nEND;