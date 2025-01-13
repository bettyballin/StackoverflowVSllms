CREATE TRIGGER Club_Update_Trigger\nON Club\nAFTER UPDATE\nAS\nBEGIN\n    IF UPDATE(idCoach)\n    BEGIN\n        -- Update Coach table\n        UPDATE c\n        SET c.idClub = NULL\n        FROM Coach c\n        INNER JOIN inserted i ON c.idCoach = i.idCoach\n\n        -- Create temporary table to store affected Coach records\n        SELECT idCoach, idClub\n        INTO #AffectedCoaches\n        FROM Coach\n        WHERE idClub IS NOT NULL\n    END\nEND\n\nCREATE TRIGGER Coach_Update_Trigger\nON Coach\nAFTER UPDATE\nAS\nBEGIN\n    IF UPDATE(idClub)\n    BEGIN\n        -- Update Club table based on temporary table\n        UPDATE c\n        SET c.idCoach = NULL\n        FROM Club c\n        INNER JOIN #AffectedCoaches ac ON c.idClub = ac.idClub\n    END\nEND