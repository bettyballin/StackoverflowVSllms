$pdo = new PDO("mysql:host=your_host;dbname=your_db", 'username', 'password');\n$stmt = $pdo->prepare("SELECT `player_id`, COUNT(*) as conversion_count FROM `conversions` WHERE `game_id` = :game_id AND `team_id` IS NULL GROUP BY `player_id`);\n$stmt->execute([':game_id' => $game_id]);\n\nwhile ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n    // same logic to handle rows\n}