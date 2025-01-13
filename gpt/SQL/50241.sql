CREATE TABLE Games (\n    game_id INT PRIMARY KEY,\n    round INT,\n    team1_id INT,\n    team2_id INT,\n    team1_score INT,\n    team2_score INT,\n    winner_id INT,\n    FOREIGN KEY (team1_id) REFERENCES Teams(team_id),\n    FOREIGN KEY (team2_id) REFERENCES Teams(team_id),\n    FOREIGN KEY (winner_id) REFERENCES Teams(team_id)\n);