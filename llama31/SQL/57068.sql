CREATE TRIGGER trg_PreventDeletionOfMasterAccounts\nON YourTable\nINSTEAD OF DELETE\nAS\nBEGIN\n    IF EXISTS (SELECT 1 FROM deleted WHERE id IN (0, 1, 2))\n    BEGIN\n        RAISERROR ('Cannot delete master accounts', 16, 1)\n        ROLLBACK TRANSACTION\n    END\n    ELSE\n    BEGIN\n        DELETE FROM YourTable WHERE id IN (SELECT id FROM deleted)\n    END\nEND