SELECT b.profname\nFROM committee b\nWHERE NOT EXISTS (\n  SELECT commname\n  FROM committee a\n  WHERE a.profname = 'piper'\n  AND NOT EXISTS (\n    SELECT 1\n    FROM committee c\n    WHERE c.commname = a.commname\n    AND c.profname = b.profname\n  )\n)