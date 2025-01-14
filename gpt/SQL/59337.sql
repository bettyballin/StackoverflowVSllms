SELECT \n    userid, \n    MAX(elo) as current_elo, \n    COUNT(*) as cnt \nFROM\n(\n    SELECT \n        winner as userid, \n        winner_elo as elo, \n        reported_on \n    FROM webl_games \n    WHERE reported_on > NOW() - INTERVAL 4 DAY\n    UNION ALL \n    SELECT \n        loser as userid, \n        loser_elo as elo, \n        reported_on \n    FROM webl_games \n    WHERE reported_on > NOW() - INTERVAL 4 DAY\n) t\nGROUP BY userid\nHAVING COUNT(*) >= 3\nORDER BY current_elo DESC;