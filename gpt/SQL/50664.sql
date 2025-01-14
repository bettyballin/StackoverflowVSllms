WITH RankedScores AS (\n    SELECT \n        score_id, \n        user_id, \n        game_id, \n        thescore, \n        timestamp,\n        ROW_NUMBER() OVER (PARTITION BY game_id ORDER BY thescore DESC) AS score_rank\n    FROM \n        score\n)\nSELECT \n    score_id, \n    user_id, \n    game_id, \n    thescore, \n    timestamp\nFROM \n    RankedScores\nWHERE \n    score_rank <= 3\n    AND user_id = [SPECIFIC_USER_ID];