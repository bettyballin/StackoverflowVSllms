SELECT u.*, n.subject, n.heading, n.body, n.timestamp\nFROM users u\nJOIN notes n ON u.id = n.user_id\nJOIN (\n  SELECT user_id, MAX(timestamp) as max_timestamp\n  FROM notes\n  GROUP BY user_id\n) latest_notes ON n.user_id = latest_notes.user_id AND n.timestamp = latest_notes.max_timestamp;