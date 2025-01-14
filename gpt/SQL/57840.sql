SELECT b.*\nFROM bar b\nJOIN (\n    SELECT foo_id, MAX(timestamp) AS latest_timestamp\n    FROM bar\n    GROUP BY foo_id\n) latest_b\nON b.foo_id = latest_b.foo_id AND b.timestamp = latest_b.latest_timestamp;