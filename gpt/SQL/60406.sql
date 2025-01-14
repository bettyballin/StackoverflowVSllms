-- Create an index on game, win, and loss columns\nCREATE INDEX idx_game_range ON games (game);\nCREATE INDEX idx_win_loss ON games (win, loss);\n\n-- Optimized Query\nSELECT SUBSTRING(game, {$len}, 1) AS move,\n       COUNT(*) AS games,\n       SUM(win) AS wins,\n       SUM(loss) AS losses\nFROM games\nWHERE game > {$something} AND game < {$something_else}\nGROUP BY move;