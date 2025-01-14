-- Assuming 'snapshot_time' is the recorded timestamp when the user started pagination\n\n-- Fetching the first page\nSELECT * FROM questions WHERE created_at <= 'snapshot_time' ORDER BY created_at DESC LIMIT 10 OFFSET 0;\n\n-- Fetching the second page\nSELECT * FROM questions WHERE created_at <= 'snapshot_time' ORDER BY created_at DESC LIMIT 10 OFFSET 10;