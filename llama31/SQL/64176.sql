SELECT r1.*\nFROM rpc_responses r1\nINNER JOIN (\n  SELECT method, id, MAX(timestamp) as max_timestamp\n  FROM rpc_responses\n  GROUP BY method, id\n) r2\nON r1.method = r2.method AND r1.id = r2.id AND r1.timestamp = r2.max_timestamp;