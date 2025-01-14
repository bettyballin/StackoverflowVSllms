-- Assume the following simplified table structures\n\nCREATE TABLE Users (\n    user_id INT PRIMARY KEY,\n    username VARCHAR(255)\n);\n\nCREATE TABLE friendships (\n    friend1_id INT,\n    friend2_id INT,\n    PRIMARY KEY (friend1_id, friend2_id),\n    FOREIGN KEY (friend1_id) REFERENCES Users(user_id),\n    FOREIGN KEY (friend2_id) REFERENCES Users(user_id)\n);\n\nCREATE TABLE Events (\n    event_id INT PRIMARY KEY,\n    user_id INT,\n    event_data TEXT,\n    event_time TIMESTAMP,\n    FOREIGN KEY (user_id) REFERENCES Users(user_id)\n);\n\n-- Query to find recent events from a user's friends\n\nSELECT e.event_id, u.username, e.event_data, e.event_time\nFROM Events e\nJOIN friendships f ON e.user_id = f.friend2_id\nJOIN Users u ON e.user_id = u.user_id\nWHERE f.friend1_id = :current_user_id\nORDER BY e.event_time DESC;