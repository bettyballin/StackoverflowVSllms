-- Fetching the first page\nSELECT * FROM questions WHERE created_at < 'timestamp' ORDER BY created_at DESC LIMIT 10;\n\n-- Fetching the second page using the timestamp of the last record on the first page\nSELECT * FROM questions WHERE created_at < 'last_seen_timestamp' ORDER BY created_at DESC LIMIT 10;