CREATE TABLE member_to_previous_positions (\n       member_id INT,\n       position_id INT,\n       team_id INT,\n       start_date DATE,\n       end_date DATE,\n       PRIMARY KEY (member_id, position_id, team_id),\n       FOREIGN KEY (member_id) REFERENCES member(member_id),\n       FOREIGN KEY (position_id) REFERENCES positions(position_id),\n       FOREIGN KEY (team_id) REFERENCES team(team_id)\n   );