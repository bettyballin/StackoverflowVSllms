SELECT \n  p.player_id, \n  p.number, \n  pl.name, \n  pl.surname,\n  COALESCE(t.tries, 0) AS nrTries,\n  COALESCE(c.conversions, 0) AS nrConversions,\n  COALESCE(d.dropgoals, 0) AS nrDropgoals,\n  COALESCE(pe.penalties, 0) AS nrPenalties\nFROM \n  players p\n  LEFT JOIN player pl ON p.player_id = pl.player_id\n  LEFT JOIN (\n    SELECT player_id, COUNT(*) AS tries \n    FROM tries \n    WHERE game_id = '$game_id'\n    GROUP BY player_id\n  ) t ON p.player_id = t.player_id\n  LEFT JOIN (\n    SELECT player_id, COUNT(*) AS conversions \n    FROM conversions \n    WHERE game_id = '$game_id'\n    GROUP BY player_id\n  ) c ON p.player_id = c.player_id\n  LEFT JOIN (\n    SELECT player_id, COUNT(*) AS dropgoals \n    FROM dropgoals \n    WHERE game_id = '$game_id'\n    GROUP BY player_id\n  ) d ON p.player_id = d.player_id\n  LEFT JOIN (\n    SELECT player_id, COUNT(*) AS penalties \n    FROM penalties \n    WHERE game_id = '$game_id'\n    GROUP BY player_id\n  ) pe ON p.player_id = pe.player_id\nWHERE \n  p.team_id IS NULL \n  AND p.game_id = '$game_id'\nORDER BY \n  p.number;