-- Table for games or rating instances\nCREATE TABLE ratings (\n    game_id INT PRIMARY KEY,\n    -- other game-related fields...\n);\n\n-- Table for users who have voted on each game\nCREATE TABLE votes (\n    vote_id INT AUTO_INCREMENT PRIMARY KEY,\n    game_id INT NOT NULL,\n    user_uid INT NOT NULL,\n    UNIQUE KEY unique_vote (game_id, user_uid),\n    FOREIGN KEY (game_id) REFERENCES ratings(game_id)\n);