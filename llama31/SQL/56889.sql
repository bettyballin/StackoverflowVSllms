CREATE TABLE votes (\n  comment_id INT NOT NULL,\n  user_id INT NOT NULL,\n  vote TINYINT NOT NULL,\n  PRIMARY KEY (comment_id, user_id)\n);