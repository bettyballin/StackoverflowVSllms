DROP TRIGGER [OnItem_Updated];\n    -- Perform necessary modifications such as adding a new trigger\n    CREATE TRIGGER [OnItem_Updated]\n        ON [Item]\n       AFTER UPDATE\n    AS \n    BEGIN\n        SET NOCOUNT ON;\n    \n        IF update(State)\n        BEGIN\n            /* Trigger logic */\n        END\n    END