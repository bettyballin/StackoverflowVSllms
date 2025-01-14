SELECT \n    team_id,\n    SUM(CASE WHEN position = 'home' THEN 1 ELSE 0 END) as home_games,\n    SUM(CASE WHEN position = 'away' THEN 1 ELSE 0 END) as away_games\nFROM (\n    SELECT home_team_id AS team_id, 'home' AS position FROM game\n    UNION ALL\n    SELECT away_team_id AS team_id, 'away' AS position FROM game\n) AS teams\nGROUP BY team_id;