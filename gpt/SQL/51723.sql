DELETE FROM foo\nWHERE id = 1\nAND NOT EXISTS (\n    SELECT 1\n    FROM bar\n    WHERE bar.id = foo.id\n);