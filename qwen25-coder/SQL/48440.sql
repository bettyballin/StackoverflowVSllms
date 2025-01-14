SELECT \n    players.player_id, \n    players.number, \n    player.name, \n    player.surname,\n    IF(COUNTS.nrTries = 0, '&nbsp;', COUNTS.nrTries) AS nrTries,\n    IF(COUNTS.nrConversions = 0, '&nbsp;', COUNTS.nrConversions) AS nrConversions,\n    IF(COUNTS.nrDropgoals = 0, '&nbsp;', COUNTS.nrDropgoals) AS nrDropgoals,\n    IF(COUNTS.nrPenalties = 0, '&nbsp;', COUNTS.nrPenalties) AS nrPenalties\nFROM \n    players\nLEFT JOIN \n    player ON players.player_id = player.player_id\nLEFT JOIN (\n    SELECT player_id, COUNT(*) as nrTries\n    FROM tries\n    WHERE game_id = '$game_id'\n    GROUP BY player_id\n) AS COUNTS ON players.player_id = COUNTS.player_id\nLEFT JOIN (\n    SELECT player_id, COUNT(*) as nrConversions\n    FROM conversions\n    WHERE game_id = '$game_id'\n    GROUP BY player_id\n) AS COUNTSC ON players.player_id = COUNTSC.player_id\nLEFT JOIN (\n    SELECT player_id, COUNT(*) as nrDropgoals\n    FROM dropgoals\n    WHERE game_id = '$game_id'\n    GROUP BY player_id\n) AS COUNTSDG ON players.player_id = COUNTSDG.player_id\nLEFT JOIN (\n    SELECT player_id, COUNT(*) as nrPenalties\n    FROM penalties\n    WHERE game_id = '$game_id'\n    GROUP BY player_id\n) AS COUNTSP ON players.player_id = COUNTSP.player_id\nWHERE \n    players.team_id IS NULL AND \n    players.game_id = '$game_id'\nGROUP BY \n    players.player_id, players.number, player.name, player.surname\nORDER BY \n    players.number;