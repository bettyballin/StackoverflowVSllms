SELECT p.player_id, p.name, COUNT(g.game_id) AS game_count\nFROM weblPlayers p\nJOIN weblGames g ON p.name = (CASE WHEN g.winner_name = p.name THEN g.winner_name ELSE g.loser_name END)\nWHERE g.reported_date >= CURDATE() - INTERVAL y DAY\nGROUP BY p.player_id, p.name\nHAVING COUNT(g.game_id) >= x;