UPDATE foo f1\nSET total_count = (\n  SELECT SUM(b1.seconds)\n  FROM bar b1\n  WHERE b1.id = f1.foo_id\n);