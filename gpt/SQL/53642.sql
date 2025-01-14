CREATE TABLE user_favored_tags (\n       user_id INT NOT NULL,\n       tag_id INT NOT NULL,\n       PRIMARY KEY (user_id, tag_id),\n       FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,\n       FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE CASCADE,\n       INDEX (user_id),\n       INDEX (tag_id)\n   );