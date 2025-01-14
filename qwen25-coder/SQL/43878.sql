DELIMITER //\n\nCREATE TRIGGER before_insert_artist_group_participation BEFORE INSERT ON Artist_Group_Participation\nFOR EACH ROW\nBEGIN\n    DECLARE group_count INT;\n    \n    -- Check if the same set of artists exists in any other group\n    SELECT COUNT(*)\n    INTO group_count\n    FROM Artist_Group_Participation existing_agp\n    WHERE NOT EXISTS (\n        SELECT 1\n        FROM Artist_Group_Participation new_agp\n        WHERE new_agp.artist_id IN (SELECT artist_id FROM Artist_Group_Participation WHERE artist_group_id = NEW.artist_group_id)\n          AND new_agp.artist_id <> existing_agp.artist_id\n    )\n      AND NOT EXISTS (\n        SELECT 1\n        FROM Artist_Group_Participation existing_apg\n        WHERE existing_apg.artist_id IN (SELECT artist_id FROM Artist_Group_Participation WHERE artist_group_id = NEW.artist_group_id)\n          AND existing_apg.artist_id <> new_agp.artist_id\n    );\n\n    IF group_count > 0 THEN\n        SIGNAL SQLSTATE '45000'\n        SET MESSAGE_TEXT = 'Artist Group with the same set of artists already exists';\n    END IF;\nEND //\n\nDELIMITER ;