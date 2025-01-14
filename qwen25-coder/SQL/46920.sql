-- Trigger for updating Coach's club reference when Club's coach changes\nCREATE TRIGGER Trg_UpdateClubCoach\nON Club\nAFTER UPDATE\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    -- Update the new coach's idClub to NULL if he previously coached another club\n    UPDATE Coach\n    SET idClub = NULL\n    FROM Coach\n    INNER JOIN inserted i ON Coach.idCoach = i.idNewCoach  -- Assuming you pass new coach ID in an additional column for clarity\n\n    -- Remove the old club - coach relationship\n    UPDATE Coach\n    SET idClub = NULL\n    FROM Coach\n    INNER JOIN deleted d ON Coach.idClub = d.idClub\n\end