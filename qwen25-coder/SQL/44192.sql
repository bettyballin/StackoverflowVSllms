CREATE TRIGGER trg_CheckPatrolOverlapInsert ON Patrols\nINSTEAD OF INSERT\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    -- Define variables to hold current row data\n    DECLARE @GuardID INT, @Starts DATETIME, @Ends DATETIME;\n\n    -- Temporary table to store clean inserts\n    DECLARE @CleanRows TABLE (\n        PatrolID INT,\n        GuardID INT,\n        Starts DATETIME,\n        Ends DATETIME\n    );\n\n    -- Iterate over the inserted rows using set-based operations\n    INSERT INTO @CleanRows (PatrolID, GuardID, Starts, Ends)\n    SELECT i.PatrolID, i.GuardID, i.Starts, i.Ends\n    FROM inserted i\n    WHERE NOT EXISTS (\n        SELECT 1 \n        FROM Patrols p \n        WHERE p.GuardID = i.GuardID \n          AND (p.Starts < i.Ends AND p.Ends > i.Starts) -- Overlapping period condition\n    );\n\n    -- Insert clean rows directly into the table if they pass validation\n    INSERT INTO Patrols (PatrolID, GuardID, Starts, Ends)\n    SELECT PatrolID, GuardID, Starts, Ends FROM @CleanRows;\n\n    -- Report any row that failed due to overlap\n    IF EXISTS (\n        SELECT 1 \n        FROM inserted i\n        WHERE NOT EXISTS (\n            SELECT 1 \n            FROM @CleanRows c \n            WHERE c.PatrolID = i.PatrolID AND c.GuardID = i.GuardID \n              AND c.Starts = i.Starts AND c.Ends = i.Ends\n        )\n    )\n    BEGIN\n        RAISERROR('One or more patrols overlap with existing patrols for the same guard.', 16, 1);\n        ROLLBACK TRANSACTION;\n    END;\nEND;