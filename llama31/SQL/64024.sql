DELETE FROM foo\nWHERE id NOT IN (\n  SELECT id\n  FROM (\n    SELECT id, user_id, timestamp,\n           ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY timestamp DESC) AS row_num\n    FROM foo\n  ) AS subquery\n  WHERE row_num <= N\n)